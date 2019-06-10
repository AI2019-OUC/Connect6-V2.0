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
		//System.out.println("��ʽ��" + (index + 1));
		return firstMoves[index];
	}

	//���ֿ�
	private static Move[] firstMoves = { new Move('J', 'K', 'K', 'I'), // ��ʽ1
			new Move('I', 'K', 'L', 'J'), // ��ʽ2
			new Move('I', 'K', 'L', 'K'), // ��ʽ3
			new Move('I', 'K', 'J', 'L'), // ��ʽ4
			new Move('J', 'K', 'K', 'J'), // ��ʽ5
			new Move('I', 'K', 'K', 'L'), // ��ʽ6
			new Move('J', 'L', 'L', 'J'), // ��ʽ7
			new Move('J', 'K', 'K', 'K'), // ��ʽ8
			new Move('J', 'L', 'L', 'L'), // ��ʽ9
			new Move('K', 'I', 'I', 'K'), // ��ʽ10
			new Move('J', 'K', 'L', 'J'), // ��ʽ11
			new Move('K', 'H', 'J', 'K'), // ��ʽ12
			new Move('L', 'H', 'J', 'L'), // ��ʽ13
			new Move('J', 'I', 'J', 'K'), // ��ʽ14
			new Move('I', 'L', 'K', 'L'), // ��ʽ15
			new Move('J', 'H', 'J', 'L'), // ��ʽ16
			new Move('J', 'L', 'L', 'K'), // ��ʽ17
			new Move('J', 'K', 'K', 'L'), // ��ʽ18
			new Move('L', 'I', 'J', 'K'), // ��ʽ19
			new Move('I', 'K', 'L', 'K'), // ��ʽ20
			new Move('J', 'L', 'K', 'L'), // ��ʽ21
			new Move('L', 'I', 'I', 'K'), // ��ʽ22
			new Move('I', 'K', 'I', 'L'), // ��ʽ23
			new Move('L', 'H', 'J', 'K'), // ��ʽ24
			new Move('J', 'K', 'L', 'K'), // ��ʽ25
			new Move('J', 'K', 'J', 'L') // ��ʽ26

			// ��ʽ9, 3, 2, 8, 12, 19, 20, 23, ���ַ�Ӯ�ˡ�
			
			// MaxDepth = 2: ��ʤ��26, 9, 3, 4(42), 5, 6, 10, 11
			//               ��ʤ��2, 1, 8(43)
	};
}