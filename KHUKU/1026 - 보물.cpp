#include<iostream>
#include<algorithm>
using namespace std;

int N, A[50], B[50], C[50], s = 0;

int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> A[i];
	}
	for (int i = 0; i < N; i++) {
		cin >> B[i];
		C[i] = B[i];
	}
	sort(A, A + N);
	sort(C, C + N, greater<int>());
	for (int i = 0; i < N; i++) {
		s += A[i] * C[i];
	}
	cout << s;
	return 0;
}

//S = A[0] * B[0] + A[1] * B[1] + A[2] * B[2] + A[3] * B[3]�� �� A�迭�� ���ҵ��� ������ ��迭 �� �� �����Ƿ� S = A[0] * B[0] + A[3] * B[1] + A[2] * B[2] + A[1] * B[3] ���� ������ ���̴�.
//�� �� ���� ������ ��迭�ϸ� S = A[0] * B[0] + A[1] * B[3] + A[2] * B[2] + A[3] * B[1]�̹Ƿ� A�迭�� ���ҵ��� ���ġ �� �� �ִٴ� ���� B�迭�� ���ҵ� ���� ���ġ �� �� �ִٴ� ���� �ǹ��Ѵٴ� ���� �� �� �ִ�.