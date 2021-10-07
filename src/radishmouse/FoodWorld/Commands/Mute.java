package radishmouse.FoodWorld.Commands;

import java.util.List;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import radishmouse.FoodWorld.FoodWorld;

public class Mute extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		if (args[0].equalsIgnoreCase(FoodWorld.prefix + "mute")) {
			if	(hasRole("Owner", event) || hasRole("Mod", event)) {
				List<Member> mentions = event.getMessage().getMentionedMembers();
				if (mentions.isEmpty()) {
					EmbedBuilder msg = FoodWorld.sendMessage("Specify Who To Mute", "Usage: `" + FoodWorld.prefix + "mute [@mention who to mute]`", "Blue");
					event.getChannel().sendMessageEmbeds(msg.build()).queue();
				}
				else if (mentions.size() > 1) {
					EmbedBuilder msg = FoodWorld.sendMessage("Mentioned Too Many People", "Usage: `" + FoodWorld.prefix + "mute [@mention who to mute]`", "Blue");
					event.getChannel().sendMessageEmbeds(msg.build()).queue();
				}
				else {
					try {
						if (!hasRole("Muted", mentions.get(0))) {
							event.getGuild().addRoleToMember(mentions.get(0), event.getGuild().getRolesByName("Muted", true).get(0)).queue();
							EmbedBuilder msg = FoodWorld.sendMessage(null, "Succesfully muted " + mentions.get(0).getAsMention().toString(), "Blue");
							event.getChannel().sendMessageEmbeds(msg.build()).queue();
						}
						else {
							event.getGuild().removeRoleFromMember(mentions.get(0), event.getGuild().getRolesByName("Muted", true).get(0)).queue();
							EmbedBuilder msg = FoodWorld.sendMessage(null, "Succesfully un-muted " + mentions.get(0).getAsMention().toString(), "Blue");
							event.getChannel().sendMessageEmbeds(msg.build()).queue();
						}
					}
					catch (Exception e) {
						if (e.toString().startsWith("net.dv8tion.jda.api.exceptions.HierarchyException:")) {
							EmbedBuilder msg = FoodWorld.sendMessage("Bot unable to mute", "Please make sure that FoodBot's role is higher in the role hierarchy in your server settings", "Blue");
							event.getChannel().sendMessageEmbeds(msg.build()).queue();
						}
					}
				}
			}
		}
	}
	
	public static boolean hasRole(String string, GuildMessageReceivedEvent event) {
		Boolean toReturn = false;
		
		for(int i=0; i < event.getMember().getRoles().size(); i++){
			if(string.equals(event.getMember().getRoles().get(i).getName())){
				toReturn = true;
		    }
		}
		
		return toReturn;
	}
	public static boolean hasRole(String string, Member member) {
		Boolean toReturn = false;
		
		for(int i=0; i < member.getRoles().size(); i++){
			if(string.equals(member.getRoles().get(i).getName())){
				toReturn = true;
		    }
		}
		
		return toReturn;
	}
}
