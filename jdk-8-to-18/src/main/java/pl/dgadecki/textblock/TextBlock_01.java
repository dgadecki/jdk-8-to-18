package pl.dgadecki.textblock;

public class TextBlock_01 {

    public static void main(String[] args) {
        //String textBlock = """Example Text Block""";

        System.out.println("------ LOREM IPSUM -------");
        System.out.println(getLoremIpsumFromStandard());
        System.out.println(getLoremIpsumFromTextBlock());

        System.out.println("------ HTML -------");
        System.out.println(getHtmlFromStandard());
        System.out.println(getHtmlFromTextBlock());

        System.out.println("------ JSON -------");
        System.out.println(getJsonFromStandard());
        System.out.println(getJsonFromTextBlock());

        System.out.println("------ LOREM IPSUM INDENTED -------");
        System.out.println(getLoremIpsumIndented());

        System.out.println("------ Concat of two text blocks ------");
        System.out.println(getHtmlFromTextBlock() + getJsonFromTextBlock());

        System.out.println("------ Concat text block + standard ------");
        System.out.println(getHtmlFromTextBlock() + getJsonFromStandard());

        System.out.println("------ LOREM IPSUM ONE LINE ------");
        System.out.println(getLoremIpsumFromTextBlockOneLine());

        System.out.println("------ WHITESPACE REMOVAL - PART 1 -------");
        System.out.println(getCars1());
        System.out.println(getCars2());

        System.out.println("------ WHITESPACE REMOVAL - PART 2 -------");
        System.out.println(getCars3());
        System.out.println(getCars4());

        System.out.println("------ ESCAPING SPECIAL CHARACTERS ---------");
        System.out.println(getLoremIpsumWithTripleQuotationMarks());
    }

    private static String getLoremIpsumFromStandard() {
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ultricies felis nibh, et fermentum augue dapibus ac.\n" +
                "Cras sagittis massa et dictum dictum. Phasellus lorem felis, aliquet cursus convallis vitae, luctus id ipsum.\n" +
                "Etiam accumsan lorem at mi molestie semper. Nulla in dapibus velit. Fusce bibendum quam ut purus feugiat vestibulum.\n" +
                "Mauris vestibulum augue eu pharetra congue. Morbi id leo neque. Pellentesque habitant morbi tristique senectus et netus\n" +
                "et malesuada fames ac turpis egestas. Integer vel ex ac quam rutrum ultricies. Phasellus commodo augue ut volutpat bibendum.\n" +
                "Quisque suscipit nisi eget turpis convallis, eu vestibulum odio fringilla. Fusce et commodo erat, sit amet egestas nulla.\n" +
                "Sed sodales pretium sapien id porta. Morbi imperdiet, augue quis facilisis auctor, mi ante porta mi, at consequat lorem nibh id dui.\n" +
                "Morbi tincidunt scelerisque massa at semper.";
    }

    private static String getLoremIpsumFromTextBlock() {
        return  """
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ultricies felis nibh, et fermentum augue dapibus ac.
                Cras sagittis massa et dictum dictum. Phasellus lorem felis, aliquet cursus convallis vitae, luctus id ipsum.
                Etiam accumsan lorem at mi molestie semper. Nulla in dapibus velit. Fusce bibendum quam ut purus feugiat vestibulum.
                Mauris vestibulum augue eu pharetra congue. Morbi id leo neque. Pellentesque habitant morbi tristique senectus et netuss
                et malesuada fames ac turpis egestas. Integer vel ex ac quam rutrum ultricies. Phasellus commodo augue ut volutpat bibendum.
                Quisque suscipit nisi eget turpis convallis, eu vestibulum odio fringilla. Fusce et commodo erat, sit amet egestas nulla.s
                Sed sodales pretium sapien id porta. Morbi imperdiet, augue quis facilisis auctor, mi ante porta mi, at consequat lorem nibh id dui.
                Morbi tincidunt scelerisque massa at semper.
                """;
    }

    private static String getHtmlFromStandard() {
        return "<html>\n" +
               "    <body>\n" +
               "        <p>Hello, world</p>\n" +
               "    </body>\n" +
               "</html>\n";
    }

    private static String getHtmlFromTextBlock() {
        return """
                <html>
                    <body>
                        <p>Hello, world</p>
                    </body>
                </html>
                """;
    }

    private static String getJsonFromStandard() {
        return "{\n" +
                "\t\"name\": \"John\",\n" +
                "\t\"age\": 30,\n" +
                "\t\"car\": \"BMW\"\n" +
                "}\n";
    }

    private static String getJsonFromTextBlock() {
        return """
                {
                	"name": "John",
                	"age": 30,
                	"car": "BMW"
                }
                """;
    }

    private static String getLoremIpsumIndented() {
        return """
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ultricies felis nibh, et fermentum augue dapibus ac.
                Cras sagittis massa et dictum dictum. Phasellus lorem felis, aliquet cursus convallis vitae, luctus id ipsum.
                Etiam accumsan lorem at mi molestie semper. Nulla in dapibus velit. Fusce bibendum quam ut purus feugiat vestibulum.
                Mauris vestibulum augue eu pharetra congue. Morbi id leo neque. Pellentesque habitant morbi tristique senectus et netuss
                et malesuada fames ac turpis egestas. Integer vel ex ac quam rutrum ultricies. Phasellus commodo augue ut volutpat bibendum.
                Quisque suscipit nisi eget turpis convallis, eu vestibulum odio fringilla. Fusce et commodo erat, sit amet egestas nulla.s
                Sed sodales pretium sapien id porta. Morbi imperdiet, augue quis facilisis auctor, mi ante porta mi, at consequat lorem nibh id dui.
                Morbi tincidunt scelerisque massa at semper.
                                    """;
    }

    private static String getLoremIpsumFromTextBlockOneLine() {
        return """
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ultricies felis nibh, et fermentum augue dapibus ac. \
                Cras sagittis massa et dictum dictum. Phasellus lorem felis, aliquet cursus convallis vitae, luctus id ipsum. \
                Etiam accumsan lorem at mi molestie semper. Nulla in dapibus velit. Fusce bibendum quam ut purus feugiat vestibulum. \
                Mauris vestibulum augue eu pharetra congue. Morbi id leo neque. Pellentesque habitant morbi tristique senectus et netuss \
                et malesuada fames ac turpis egestas. Integer vel ex ac quam rutrum ultricies. Phasellus commodo augue ut volutpat bibendum. \
                Quisque suscipit nisi eget turpis convallis, eu vestibulum odio fringilla. Fusce et commodo erat, sit amet egestas nulla.s \
                Sed sodales pretium sapien id porta. Morbi imperdiet, augue quis facilisis auctor, mi ante porta mi, at consequat lorem nibh id dui. \
                Morbi tincidunt scelerisque massa at semper.
                """;
    }

    private static String getCars1() {
        return """
               Audi          
               BMW           
               Mercedes      
               Ferrari       
               Pagani        
               """;
    }

    private static String getCars2() {
        return """
               Audi          \s
               BMW           \s
               Mercedes      \s
               Ferrari       \s
               Pagani        \s
               """;
    }

    private static String getCars3() {
        return """
               Audi
               BMW
               Mercedes
               Ferrari
               Pagani
               """;
    }

    private static String getCars4() {
        return """
           			Audi
                            
           		 BMW
           	      Mercedes
           	      Ferrari
           					Pagani""";
    }

    private static String getLoremIpsumWithTripleQuotationMarks() {
        return """
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ultricies felis nibh, et fermentum augue dapibus ac. \"""
                Cras sagittis massa et dictum dictum. Phasellus lorem felis, aliquet cursus convallis vitae, luctus id ipsum.        \\
                Etiam accumsan lorem at mi molestie semper. Nulla in dapibus velit. Fusce bibendum quam ut purus feugiat \t vestibulum.
                """;
    }
}
