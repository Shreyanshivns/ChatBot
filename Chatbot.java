import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

import java.util.List;
import java.util.Properties;

public class Chatbot {
    private StanfordCoreNLP pipeline;

    public Chatbot() {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        pipeline = new StanfordCoreNLP(props);
    }

    public String respond(String input) {
        Annotation annotation = new Annotation(input);
        pipeline.annotate(annotation);

        String sentiment = getSentiment(annotation);
        String intent = getIntent(annotation);

        if (sentiment.equals("POSITIVE")) {
            if (intent.equals("GREETING")) {
                return "Hello! How can I help you today?";
            } else if (intent.equals("THANK_YOU")) {
                return "You're welcome!";
            } else {
                return "I'm happy to help you with that!";
            }
        } else if (sentiment.equals("NEGATIVE")) {
            if (intent.equals("COMPLAINT")) {
                return "Sorry to hear that. Can you tell me more about the issue?";
            } else {
                return "I apologize if I couldn't help you. Can I try again?";
            }
        } else {
            return "I didn't understand that. Can you please rephrase?";
        }
    }

    private String getSentiment(Annotation annotation) {
        int sentiment = 0;
        for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
            Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
            sentiment = RNNCoreAnnotations.getPredictedClass(tree);
        }
        if (sentiment == 2 || sentiment == 3) {
            return "POSITIVE";
        } else if (sentiment == 0 || sentiment == 1) {
            return "NEGATIVE";
        } else {
            return "NEUTRAL";
        }
    }

    private String getIntent(Annotation annotation) {
        for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
            String text = sentence.toString();
            if (text.contains("hello") || text.contains("hi")) {
                return "GREETING";
            } else if (text.contains("thank") || text.contains("thanks")) {
                return "THANK_YOU";
            } else if (text.contains("problem") || text.contains("issue")) {
                return "COMPLAINT";
            } else {
                return "OTHER";
            }
        }
        return "OTHER";
    }
}