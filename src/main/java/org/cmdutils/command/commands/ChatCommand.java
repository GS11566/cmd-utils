package org.cmdutils.command.commands;

import org.cmdutils.command.Command;
import org.cmdutils.command.CommandEnvironment;
import org.cmdutils.command.Commands;
import org.cmdutils.terminal.logger.Logger;

public class ChatCommand extends Command {
    public ChatCommand() {
        super("chat", "Send chat message, use \"/\" <command> to execute commands instead.", "Syntax: \"chat args0[\"Text in spaces w/ double quotes\"]\"\nor, \"chat args0[noSpacesNoQuotes]\"", null);
    }

    @Override
    public int execute(String[] args, Logger logger, CommandEnvironment env) {
        if (client.getNetworkHandler() == null) {
            logger.error("You are not connected to a server.");
            return Commands.COMMAND_FAILURE;
        }

        if (args.length == 1) {
            client.getNetworkHandler().sendChatMessage(args[0]);
            logger.info("Sent chat message.");
            return Commands.COMMAND_SUCCESS;
        }

        logger.error("Invalid Arguments.");

        return Commands.COMMAND_FAILURE;
    }
}
