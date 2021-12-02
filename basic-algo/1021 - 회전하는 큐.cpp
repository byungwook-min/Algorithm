#include<iostream>
#include<deque>
#include<algorithm>
using namespace std;
#define FASTIO ios::sync_with_stdio(0); cin.tie(0);

int main() {
	FASTIO;
	int N, M, ans = 0;
	cin >> N >> M;
	deque<int> DQ;
	for (int i = 0; i < N; i++) {
		DQ.push_back(i + 1);
	}
	while (M--) {
		int temp, cnt = 0;
		cin >> temp;
		while (DQ.front() != temp) { // if (idx < DQ.size() - idx)�� ���� ����� ��ġ �ľ��ϰ� ����Ҽ���.
			DQ.push_back(DQ.front());
			DQ.pop_front();
			cnt++;
		}
		ans += min((int)DQ.size() - cnt, cnt);
		DQ.pop_front();
	}
	cout << ans;
	return 0;
}

/*
20��° �ٿ���, ������ idx�� �׻� DQ.size()���� �۾Ƽ� ������ ������
DQ.size()�� unsigned int(or unsigned long long)�̱�
������ ���� idx�� DQ.size()���� �Ǵٸ� overflow�� �߻���
�ǵ��Ѵ�� �������� ���� �� ������ �����ؾ� ��. �׷��� size()��
�޾ƿ� ���� ���ؼ��� �����ϰ� (int)DQ.size() �� �׻� ����ȯ��
�ϴ� �͵� ������.
*/