import dotenv from "dotenv";
dotenv.config();

import path from "path";
import { fileURLToPath } from "url";
import { getChangedFiles } from "./services/githubClient.js";
import { analyzeFeatureFile } from "./services/aiAnalyzer.js";
import { Octokit } from "@octokit/rest";

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const octokit = new Octokit({ auth: process.env.GITHUB_TOKEN });

const owner = process.env.GITHUB_REPOSITORY_OWNER;
const repo = process.env.GITHUB_REPOSITORY.split("/")[1];
const pull_number = parseInt(process.env.PR_NUMBER, 10);

(async () => {
  const changedFiles = await getChangedFiles(owner, repo, pull_number);
  const featureFiles = changedFiles.filter(file => file.endsWith(".feature"));

  for (const file of featureFiles) {
    const fullPath = path.join(__dirname, "src/test/resources/features", file.split("/").pop());
    const analysis = await analyzeFeatureFile(fullPath);

    await octokit.issues.createComment({
      owner,
      repo,
      issue_number: pull_number,
      body: `🧠 **Analyse IA du fichier \`${file}\`** :\n\n${analysis}`,
    });
  }
})();
