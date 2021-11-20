#include<iostream>
using namespace std;
#define FASTIO ios::sync_with_stdio(0); cin.tie(0);

int n, x, cnt = 0;
int num[1000001] = {};
bool chk[2000001];

int main() {
	FASTIO;
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> num[i];
	}
	cin >> x;

	for (int i = 0; i < n; i++) {
		if(x - num[i]>=0)
			if (chk[x - num[i]] == 1) {
				cnt++;
			}
		chk[num[i]] = 1;
	}
	cout << cnt;
	return 0;
}

/*
�������⵵ O(2000000), �ð����⵵ O(n)�� Ǯ�̰� ����. ���� �Է� ���Ŀ���
x�� a �迭���� ���� �־����ٸ� int a[] �迭�� �ʿ䰡 ������.
*/