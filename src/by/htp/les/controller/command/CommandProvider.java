package by.htp.les.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.les.controller.command.impl.AddNews;
import by.htp.les.controller.command.impl.CoToRegistrationPage;
import by.htp.les.controller.command.impl.DeleteNews;
import by.htp.les.controller.command.impl.GoToAddNewsPage;
import by.htp.les.controller.command.impl.GoToIndexPage;
import by.htp.les.controller.command.impl.GoToMainPage;
import by.htp.les.controller.command.impl.Localization;
import by.htp.les.controller.command.impl.Logination;
import by.htp.les.controller.command.impl.Logout;
import by.htp.les.controller.command.impl.ReadNews;
import by.htp.les.controller.command.impl.SaveNewUser;
import by.htp.les.controller.command.impl.SaveNews;
import by.htp.les.controller.command.impl.UpdateNews;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put(CommandName.LOGINATION, new Logination());
		commands.put(CommandName.REGISTRATION, new CoToRegistrationPage());
		commands.put(CommandName.SAVENEWUSER, new SaveNewUser());
		commands.put(CommandName.GOTOINDEXPAGE, new GoToIndexPage());
		commands.put(CommandName.GOTOMAINPAGE, new GoToMainPage());
		commands.put(CommandName.LOGOUT, new Logout());
		commands.put(CommandName.READNEWS, new ReadNews());
		commands.put(CommandName.UPDATENEWS, new UpdateNews());
		commands.put(CommandName.SAVENEWS, new SaveNews());
		commands.put(CommandName.DELETENEWS, new DeleteNews());
		commands.put(CommandName.ADDNEWS, new AddNews());
		commands.put(CommandName.GOTOADDNEWSPAGE, new GoToAddNewsPage());
		commands.put(CommandName.LOCALIZATION, new Localization());
		
	}

	public Command takeCommand(String name) {
		CommandName commandName;
		commandName = CommandName.valueOf(name.toUpperCase());
		return commands.get(commandName);
	}
}
