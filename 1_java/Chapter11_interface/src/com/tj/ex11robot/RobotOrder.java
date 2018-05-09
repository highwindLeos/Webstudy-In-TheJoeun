package com.tj.ex11robot;
// �κ��� Ư���� �ľ� �Ͽ� ���� ��Ų��.
public class RobotOrder {
	public void action(IRobot robot) {
		// robot�� Singrobot �� ��ü������ robot�� Singrobot ���� ����ȯ�� sing();
		// robot�� Dancerobot �� ��ü������ robot�� Dancerobot ���� ����ȯ�� dance();
		// robot�� Drawrobot �� ��ü������ robot�� Drawrobot ���� ����ȯ�� draw();
		
		if (robot instanceof SingRobot) { //instanceof : ��ü������ ������ ���� ������ ��� �´ٸ� true
			((SingRobot)robot).sing();
		}else if (robot instanceof DanceRobot) {
			((DanceRobot)robot).dance();
		}else if (robot instanceof DrawRobot) {
			((DrawRobot)robot).draw();
		} else {
			System.out.println("�͸� Ŭ������ �������. Ȯ���غ�����.(�ٸ� Ÿ���� ���� ���Խ��ϱ�?)");
		}

	}
}
