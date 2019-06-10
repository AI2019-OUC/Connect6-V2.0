package core.player;

import java.util.Random;

import core.game.Move;

public abstract class AI extends Player {
	
	public AI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public final boolean isManual() {
		// TODO Auto-generated method stub
		return false;
	}

	protected Move firstMove() {
		Random rand = new Random();
		int index = rand.nextInt(firstMoves.length);
		//index = 14;
		//System.out.println("定式：" + (index + 1));
		return firstMoves[index];
	}

	//开局库
	private static Move[] firstMoves = { new Move('J', 'K', 'K', 'I'), // 定式1
			new Move('I', 'K', 'L', 'J'), // 定式2
			new Move('I', 'K', 'L', 'K'), // 定式3
			new Move('I', 'K', 'J', 'L'), // 定式4
			new Move('J', 'K', 'K', 'J'), // 定式5
			new Move('I', 'K', 'K', 'L'), // 定式6
			new Move('J', 'L', 'L', 'J'), // 定式7
			new Move('J', 'K', 'K', 'K'), // 定式8
			new Move('J', 'L', 'L', 'L'), // 定式9
			new Move('K', 'I', 'I', 'K'), // 定式10
			new Move('J', 'K', 'L', 'J'), // 定式11
			new Move('K', 'H', 'J', 'K'), // 定式12
			new Move('L', 'H', 'J', 'L'), // 定式13
			new Move('J', 'I', 'J', 'K'), // 定式14
			new Move('I', 'L', 'K', 'L'), // 定式15
			new Move('J', 'H', 'J', 'L'), // 定式16
			new Move('J', 'L', 'L', 'K'), // 定式17
			new Move('J', 'K', 'K', 'L'), // 定式18
			new Move('L', 'I', 'J', 'K'), // 定式19
			new Move('I', 'K', 'L', 'K'), // 定式20
			new Move('J', 'L', 'K', 'L'), // 定式21
			new Move('L', 'I', 'I', 'K'), // 定式22
			new Move('I', 'K', 'I', 'L'), // 定式23
			new Move('L', 'H', 'J', 'K'), // 定式24
			new Move('J', 'K', 'L', 'K'), // 定式25
			new Move('J', 'K', 'J', 'L') // 定式26

			// 定式9, 3, 2, 8, 12, 19, 20, 23, 后手方赢了。
			
			// MaxDepth = 2: 黑胜：26, 9, 3, 4(42), 5, 6, 10, 11
			//               白胜：2, 1, 8(43)
	};
}