/*
 * QueryDatabase.java
 * 
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package utilities;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;

import utilities.internal.ConsoleReader;
import utilities.internal.DatabaseUtil;
import utilities.internal.EclipseConsole;
import utilities.internal.SchemaPrinter;
import utilities.internal.ThrowablePrinter;

public class QueryDatabase {

	public static void main(final String[] args) throws Throwable {
		DatabaseUtil databaseUtil;
		ConsoleReader reader;
		String line;
		boolean quit;

		EclipseConsole.fix();
		LogManager.getLogger("org.hibernate").setLevel(Level.OFF);
		databaseUtil = null;

		try {
			System.out.println("QueryDatabase 1.24.1");
			System.out.println("--------------------");
			System.out.println();

			System.out.printf("Initialising persistence context `%s'.%n", DatabaseConfig.PersistenceUnit);
			databaseUtil = new DatabaseUtil();
			databaseUtil.initialise();
			databaseUtil.setReadUncommittedIsolationLevel();
			System.out.println();

			reader = new ConsoleReader();
			do {
				line = reader.readCommand();
				quit = QueryDatabase.interpretLine(databaseUtil, line);
			} while (!quit);
		} catch (final Throwable oops) {
			ThrowablePrinter.print(oops);
		} finally {
			if (databaseUtil != null) {
				System.out.println("Closing persistence context.");
				databaseUtil.shutdown();
			}
		}
	}

	private static boolean interpretLine(final DatabaseUtil databaseUtil, final String line) {
		boolean result;
		String command;
		List<?> objects;
		int affected;

		result = false;
		try {
			command = StringUtils.substringBefore(line, " ");
			switch (command) {
			case "quit":
			case "exit":
				result = true;
				break;
			case "begin":
			case "open":
			case "start":
				databaseUtil.startTransaction();
				System.out.println("Transaction started");
				break;
			case "end":
			case "close":
			case "commit":
				databaseUtil.commitTransaction();
				System.out.println("Transaction committed");
				break;
			case "rollback":
				databaseUtil.rollbackTransaction();
				System.out.println("Transaction rollbacked");
				break;
			case "update":
			case "delete":
				affected = databaseUtil.executeUpdate(line);
				System.out.printf("%d objects %sd%n", affected, command);
				break;
			case "select":
				objects = databaseUtil.executeSelect(line);
				System.out.printf("%d object%s selected%n", objects.size(), (objects.size() == 1 ? "" : "s"));
				SchemaPrinter.print(objects);
				break;
			default:
				System.err.println("Command not understood");
			}
		} catch (final Throwable oops) {
			ThrowablePrinter.print(oops);
		}

		return result;
	}

}
