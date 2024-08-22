public class Main {
    public static void main(String[] args) {
        Chatbot chatbot = new Chatbot();

        System.out.println("Chatbot: Hello! How can I help you today?");
        System.out.print("User: ");
        String input = System.console().readLine();

        while (!input.equalsIgnoreCase("quit")) {
            String response = chatbot.respond(input);
            System.out.println("Chatbot: " + response);
            System.out.print("User: ");
            input = System.console().readLine();
        }
    }
}