package radishmouse.FoodWorld;

import java.util.Random;

import net.dv8tion.jda.api.entities.Activity;

public class Status {
	public static int updateTime = 60;
	private static Activity activity;
	
	private static String[] playingStatuses = {
		"🤷‍♂️ games IDK",
		"you",
		"Sam's itch.io game",
		"Minecraft =D",
		"Undertale",
		"♟ Chess",
		"a furry cosplay",
		"Muck",
		"🕹 retro games",
		"MtG with Sam",
		"League of Legends",
		"🃏 UNO",
		"🎲 Monopoly",
		"👨‍🚀 Among Us",
		"🏎 Rocket League",
		"▶ vids on YT",
		"⌨ games on PC",
		"the Gulag",
		"Skip-Bo",
		"Sorry!",
		"TF2"
	};
	private static String[] listeningStatuses = {
		"🎶 music",
		"JOJO OP's",
		"Anime intros",
		"karens yell",
		"😭 Olivia Rodrigo",
		"🥁 R&B music",
		"white noise",
		"💅 ASMR",
		"silence :(",
		"🕹 8-but tunes",
		"🕹 Super Mario themes",
		"Spotify",
		"chill tunes",
		"lo-fi hip-hop"
	};
	private static String[] watchingStatuses = {
		"you",
		"a documentary",
		"Netflix",
		"HULU",
		"Disney+",
		"Crunchyroll",
		"🥣 Naruto",
		"Jojo's Bizarre Adventure",
		"👺 Demon Slayer",
		"Attack on Titan",
		"🥩 Gordon Ramsey",
		"stuff on Twitch"
	};
		
	public static void status() {
		Random rand = new Random();
		int statusType = rand.nextInt(3);
		
		Activity act = null;
		
		switch(statusType) {
			case 0:
				act = Activity.playing(playingStatuses[rand.nextInt(playingStatuses.length)]);
				break;
			case 1:
				act = Activity.listening(listeningStatuses[rand.nextInt(listeningStatuses.length)]);
				break;
			case 2:
				act = Activity.watching(watchingStatuses[rand.nextInt(watchingStatuses.length)]);
				break;
			default:
				act = Activity.watching("this code not work");
		}
		
		activity = act;
		
		FoodWorld.jda.getPresence().setActivity(activity);
		
		new java.util.Timer().schedule( 
				new java.util.TimerTask() {
					@Override
					public void run() { status(); }
				}, updateTime * 1000
		);
	}
	
}
