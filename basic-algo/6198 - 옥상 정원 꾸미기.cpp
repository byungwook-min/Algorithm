#include<iostream>
#include<stack>
using namespace std;
#define FASTIO ios::sync_with_stdio(0); cin.tie(0);

	stack<int> s;
	int n;
	long long ans; // ans int���� ���� �� ����.

	int main() {
		FASTIO;

		cin >> n;
		int h; 
		while (n--) {
			cin >> h;
			while (!s.empty() && s.top() <= h) // s.top() Ȯ���Ϸ��� !s.empty()���� ��Ȯ�� �ʼ�.
				s.pop();
			ans += s.size(); //�׿��ִ� ���� = ���� h�� ������ �� �� �ִ� ����.
			s.push(h);
		}
		cout << ans;
		return 0;
	
}