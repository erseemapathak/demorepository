package log4j_file;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.apache.logging.log4j.LogManager;

public class LOG4j_Demo {

	private static Logger logger = LogManager.getLogger(LOG4j_Demo.class);
	public static void main(String[] args) {
	System.out.println("\n   LOG4j_Demo         \n");

	logger.info("This is information message");
	logger.error("This is an error message");
	logger.warn("This is a warn message");
	logger.fatal("This is a fatal message");
	logger.trace("This is a Trace message");
	
	System.out.println("\n   Completed ");
	
	System.out.println("");

	}

}
