package radishmouse.FoodWorld.Events;

import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReactionAdd extends ListenerAdapter {
	public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
		
		// If someone reacts with an ❌ on a bot's message, then delete it
		if (event.getReactionEmote().getName().equals("❌")) {
			if (event.getMember().getUser().equals(event.getJDA().getSelfUser())) {
				return;
			} else {
				event.getChannel().deleteMessageById(event.getMessageId()).queue();
			}
		}
	}
}
