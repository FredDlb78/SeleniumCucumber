// index.js
require("dotenv").config();
const path = require("path");
const { getChangedFiles } = require("./services/githubClient");
const { analyzeFeatureFile } = require("./services/aiAnalyzer");
const { Octokit } = require("@octokit/rest");

const octokit = new Octokit({ auth: process.env.GITHUB_TOKEN });

const owner = process.env.GITHUB_REPOSITORY_OWNER;
const repo = process.env.GITHUB_REPOSITORY.split("/")[1];
const pull_number = process.env.PR_NUMBER;

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
