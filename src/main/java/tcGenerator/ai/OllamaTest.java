package tcGenerator.ai;

import com.fasterxml.jackson.databind.ObjectMapper;
import tcGenerator.exporter.ExcelExporter;
import tcGenerator.model.FinalResponse;
import tcGenerator.model.OllamaResponse;
import tcGenerator.model.TestCase;
import tcGenerator.util.FileUtil;

import java.io.File;
import java.util.List;

public class OllamaTest {

    public static void main(String[] args) {

        try {

            // 1️⃣ Read requirement file
            String requirementText = FileUtil.readFile("src/main/resources/requirement/NewRequirement.txt");
            System.out.println("Requirement loaded successfully.\n");

            // 2️⃣ Build Prompt
            String prompt =
                    "You are a Senior QA Automation Engineer.\n\n" +
                    "Generate COMPLETE software test cases covering ALL modules:\n" +
                    "1. Login\n" +
                    "2. Product Listing\n" +
                    "3. Add to Cart\n" +
                    "4. Checkout\n" +
                    "5. Order Placement\n\n" +
                    "Include BOTH positive and negative scenarios for EACH module.\n\n" +
                    "IMPORTANT RULES:\n" +
                    "- Do NOT focus only on Login.\n" +
                    "- Every feature must have test cases.\n" +
                    "- Output VALID JSON only.\n" +
                    "- No explanations outside JSON.\n\n" +
                    "Return JSON STRICTLY in this structure:\n\n" +
                    "{\n" +
                    "  \"testCases\": [\n" +
                    "    {\n" +
                    "      \"id\": \"TC_1\",\n" +
                    "      \"title\": \"<short title>\",\n" +
                    "      \"type\": \"positive|negative\",\n" +
                    "      \"steps\": [\"step1\", \"step2\"],\n" +
                    "      \"expectedResult\": \"result\",\n" +
                    "      \"priority\": \"High|Medium|Low\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}\n\n" +
                    "Generate MULTIPLE test cases per module.\n\n" +
                    "Requirement:\n" + requirementText;

            // 3️⃣ Call Ollama
            String rawResponse = OllamaClient.generate(prompt);
            System.out.println("AI Response received.\n");

            ObjectMapper mapper = new ObjectMapper();

            OllamaResponse ollama =
                    mapper.readValue(rawResponse, OllamaResponse.class);

            FinalResponse finalResponse =
                    mapper.readValue(ollama.getResponse(), FinalResponse.class);

            List<TestCase> testCases = finalResponse.getTestCases();

            if (testCases == null || testCases.isEmpty()) {
                System.out.println("No test cases generated!");
                return;
            }

            System.out.println("Generated Test Cases: " + testCases.size());

            // 4️⃣ Print to console
            for (TestCase tc : testCases) {
                System.out.println(
                        tc.getId() + " | " +
                        tc.getTitle() + " | " +
                        tc.getType() + " | " +
                        tc.getExpectedResult() + " | " +
                        tc.getPriority()
                );
            }

            // 5️⃣ Save Excel to TARGET folder (Correct Location)
            String fileName = "CERtestcases_" + System.currentTimeMillis() + ".xlsx";
            String folderPath = "target/output/";

            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs(); // create directory automatically
            }

            String fullPath = folderPath + fileName;

            ExcelExporter.export(testCases, fullPath);

            System.out.println("\nExcel successfully created at:");
            System.out.println(new File(fullPath).getAbsolutePath());

        } catch (Exception e) {
            System.err.println("ERROR OCCURRED:");
            e.printStackTrace();
        }
    }
}
