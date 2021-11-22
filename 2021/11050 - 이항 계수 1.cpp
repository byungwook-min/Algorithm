#include<iostream>
using namespace std;
#define FASTIO ios::sync_with_stdio(0); cin.tie(0);

int main() {
	FASTIO;

	int N, K, ans = 1;
	cin >> N >> K;
	
	for (int i = N; i > N - K; i--) {
		ans *= i;
	}
	for (int i = 1; i <= K; i++) {
		ans /= i;
	}
	cout << ans;
	return 0;
}

/*���װ��(Binomial Coefficient)�� ���շп��� �����ϴ� �������� �־��� ũ�� ���տ��� 
���ϴ� ������ŭ �������� �̴� ������ �������� ���´´�.*/