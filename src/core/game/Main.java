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
    	 * addPlayer��һ���̣�����Ǵ������ļ������Player����·����
    	 * Ȼ���÷�����ƣ����ɸ�Player�Ķ���
    	 * class.forname("")
    	 */
    	
    	oucChampion.arrangeMatches();
    	
    	oucChampion.run();
    }
}
