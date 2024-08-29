package gitlet;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author Birdy
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {
        // TODO: what if args is empty?
        // 用户未输入任何参数
        if(args.length == 0) {
            System.out.println("Please enter a command.");
            return;
        }

        // 用户输入的命令未位于已初始化的 Gitlet 工作目录
        if(!Repository.GITLET_DIR.exists()) {
            System.out.println("Not in an initialized Gitlet directory.");
            return ;
        }

        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                // TODO: handle the `init` command
                Repository.MakeDirectory();
                break;
            case "add":
                // TODO: handle the `add [filename]` command

                break;
            // TODO: FILL THE REST IN
            case "commit":
                break;
            default:
                // 用户输入不存在的命令
                System.out.println("No command with that name exists.");
                break;
        }
    }
}
