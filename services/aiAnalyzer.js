// aiAnalyzer.js
const { OpenAI } = require("openai");
const fs = require("fs");

const openai = new OpenAI({ apiKey: process.env.OPENAI_API_KEY });

async function analyzeFeatureFile(filePath) {
  const content = fs.readFileSync(filePath, 'utf8');

  const completion = await openai.chat.completions.create({
    model: "gpt-4",
    messages: [
      { role: "system", content: "Tu es un expert QA, donne des feedbacks sur un fichier Gherkin" },
      { role: "user", content: `Voici le fichier :\n${content}` }
    ],
  });

  return completion.choices[0].message.content;
}

module.exports = { analyzeFeatureFile };
