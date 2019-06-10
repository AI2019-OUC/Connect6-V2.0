package core.game;

public class Main {

    public static void main(String[] args) {

    	GameEvent oucChampion = new GameEvent();
    	//oucChampion.addPlayer(new core.player.Delegate());
    	//oucChampion.addPlayer(new core.player.Dicer());
    	oucChampion.addPlayer(new baseline.player.AI());
    	oucChampion.addPlayer(new g02.player.AI());
    	//oucChampion.addPlayer(new core.player.Delegate());
    	//oucChampion.addPlayer(new core.player.Dicer());
    	
    	//oucChampion.addPlayer(new g02.player.Lucker());
    	
    	/**
    	 * addPlayer这一过程，最好是从配置文件里读出Player的类路径，
    	 * 然后用反射机制，生成该Player的对象。
    	 * class.forname("")
    	 */
    	
    	oucChampion.arrangeMatches();
    	
    	oucChampion.run();
    }
}
