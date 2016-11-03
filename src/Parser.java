/**
 * Created by student on 22.10.16.
 */
import org.apache.commons.cli.*;

public class Parser
{
    //���� ������
    String[] args = null;
    Options options = new Options();



    //���������� ��� ����� ��� ��������
    public Parser(String[] args)
    {
        this.args = args;

        options.addOption(new Option("login", "login", true, "Login: "));
        //�����, ���� -l
        options.addOption(new Option("pass", "password", true, "Password: "));

    }

    //�������� ���������� �� ������ Args
    public Args parse()
    {
        CommandLineParser cmdLineParser = new DefaultParser();
        //CommandLineParser - ��� ������, DefaultParser - ��� �������
        CommandLine cmdLine;
        //CommandLine �� ��� ������, parse ������ �����, cmdLine �������� ������
        //cmdLine.hasOption("login");
        //cmdLine.getOptionValue("login");

        Args parse1 = new Args();
        //parse1.login=cmdLine.getOptionValue("login");
        //parse1.password=cmdLine.getOptionValue("password");

        try {
            cmdLine = cmdLineParser.parse(options, args);

            if (cmdLine.hasOption("login")) {
                parse1.login = cmdLine.getOptionValue("login");
            }

            if (cmdLine.hasOption("pass")) {
                parse1.password = cmdLine.getOptionValue("pass");
            }


        } catch (ParseException e) {
            System.out.println("Parse error");
        }
        System.out.println(parse1.password);
        return parse1;
    }
}

/*
    Option option1 = new Option("l", "login", true, "Login:");
    Option option2 = new Option("2", "pass", true, "Password:");
    Option option3 = new Option("3", "role", true, "Role:");

        Option count = new Option("l", "limit", true, "������������ ���������� ������������ ���������");
        //Parser p = new Parser();
        Options options = new Options();
        options.addOption(count);
        if( line.hasOption( "l" ) ) {
            String count = line.getOptionValue( "l" );
        }


            for (int i = 0; i < users.size(); i++)
            {
                if (users.get(i).equals("jdoe"))
                {
                    System.out.println("Bingo!");
                }
                else System.out.println("ftgft!");
                break;
            }

        }
}
*/



