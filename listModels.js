import OpenAI from "openai";
import dotenv from "dotenv";
dotenv.config();

const openai = new OpenAI({ apiKey: process.env.OPENAI_API_KEY });

async function listModels() {
  const models = await openai.models.list();
  models.data.forEach((model) => {
    console.log(model.id);
  });
}

listModels();