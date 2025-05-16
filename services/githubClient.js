// githubClient.js
const { Octokit } = require("@octokit/rest");

const octokit = new Octokit({
  auth: process.env.GITHUB_TOKEN,
});

async function getChangedFiles(owner, repo, pull_number) {
  const response = await octokit.pulls.listFiles({
    owner,
    repo,
    pull_number,
  });
  return response.data.map(file => file.filename);
}