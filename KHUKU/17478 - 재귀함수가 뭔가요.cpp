#include<iostream>
#include<string>
using namespace std;
#define FASTIO std::ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
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
	FASTIO;
	cin >> N;
	cout << "��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.\n";
	recursive(N);
	return 0;
}