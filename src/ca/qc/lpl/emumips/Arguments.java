package ca.qc.lpl.emumips;


public class Arguments {

	private static Arguments args = new Arguments();
	
	public static boolean console = false;
	public static String sourcePath = null;
	
	public static boolean windowMode = true;

	public static boolean printVersion = false;
	
	
	
	private Arguments() {
		
	}
	
	public static Arguments getInstance() {
		return args;
	}
	
	// TODO: Resolve conflicts arguments e.g.: -c -w
	public static void progArguments( String[] args ) {
		
		for( int i = 0; i < args.length; ++i ) {
			
			switch( args[i].charAt(1) ) {
			
			case 'c':
				console = true;
				windowMode = false;
				sourcePath = args[++i];
			break;
			
			case 'w':
				windowMode = true;
			break;
			
			case 'v':
				printVersion = true;
			break;
			
			default:
				System.out.printf("Wrong argument: %s\n", args[i]);
				System.exit(-1);
			}
		}
	}
}
