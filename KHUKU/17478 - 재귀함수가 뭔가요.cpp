#include<iostream>
#include<string>
using namespace std;
int N, cnt=0;
void recursive(int num) {
	string ul = "";
	for (int i = 0; i < cnt; i++) ul += "____";
	cout << ul << "\"����Լ��� ������?\"\n";
	if (num == 0) {
		cout << ul <<"\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n";
		cout << ul << "��� �亯�Ͽ���.\n";
		return;
	}
	else {
		cout << ul << "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n";
		cout << ul << "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n";
		cout << ul << "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n";
		cnt++;
		}
	recursive(num - 1);
	cout << ul << "��� �亯�Ͽ���.\n";
}
int main() {
	cin >> N;
	cout << "��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.\n";
	recursive(N);
	return 0;
}