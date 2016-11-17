/**
 * Created by student on 14.11.2016.
 */
import org.apache.commons.cli.*;

public class Parser
{
    String[] args;// = null;
    Options options = new Options();

    public Parser(String[] args)
    {
        this.args = args;

        options.addOption(new Option("login", "login", true, "Login: "));
        options.addOption(new Option("pass", "password", true, "Password: "));
        options.addOption(new Option("role", "role", true, "Role: "));
        options.addOption(new Option("res", "resource", true, "Resource: "));
        options.addOption(new Option("sd", "sDate", true, "start: "));
        options.addOption(new Option("fd", "fDate", true, "fin: "));
        options.addOption(new Option("vol", "vol", true, "Volume: "));
    }

    public Args parse()
    {
        CommandLineParser cmdLineParser = new DefaultParser();
        CommandLine cmdLine;
        Args parse1 = new Args();

        try {
            cmdLine = cmdLineParser.parse(options, args);

            if (cmdLine.hasOption("login")) {
                parse1.login = cmdLine.getOptionValue("login");
            }

            if (cmdLine.hasOption("pass")) {
                parse1.password = cmdLine.getOptionValue("pass");
            }

            if (cmdLine.hasOption("role")) {
                parse1.role = cmdLine.getOptionValue("role");
            }

            if (cmdLine.hasOption("res")) {
                parse1.resource = cmdLine.getOptionValue("res");
            }
            if (cmdLine.hasOption("sd")) {
                parse1.sDate = cmdLine.getOptionValue("sd");
            }
            if (cmdLine.hasOption("fd")) {
                parse1.fDate = cmdLine.getOptionValue("fd");
            }

            if (cmdLine.hasOption("vol")) {
                parse1.vol = cmdLine.getOptionValue("vol");
            }


        } catch (ParseException e) {
            System.out.println("Parse error");
        }
        System.out.println(parse1.login+" "+parse1.password+" "+parse1.role+" "+parse1.resource);
        return parse1;
    }
}
