#include<iostream>
#include<deque>
#include<algorithm>
using namespace std;
#define FASTIO ios::sync_with_stdio(0); cin.tie(0);
void parsing(string& tmp, deque<int>& d) { // ���� parsing
	int cur = 0;
	for (int i = 1; i < (int)tmp.size() - 1; i++) { // [, ]�� ������ �ȵ��� ����, size() ����� ���� int�� ��ȯ
		if (tmp[i] == ',') {
			d.push_back(cur);
			cur = 0;
		}
		else {
			cur = 10 * cur + (tmp[i] - '0');
		}
	}
	if (cur != 0) {
		d.push_back(cur);
	}
}

void print_result(deque<int>& d) {
	cout << '[';
	for (int i = 0; i < (int)d.size(); i++)
	{
		cout << d[i];
		if (i != (int)d.size() - 1)
			cout << ',';
	}
	cout << "]\n";
}

int main() {
	FASTIO;
	int T;
	cin >> T;
	while (T--) {
		string p, s;
		int n, flag = 0; //flag �������� �������� ��Ÿ��.
		bool chk = 0; //chk �����ִ���.
		cin >> p >> n >> s;
		deque<int> DQ;
		parsing(s, DQ);
		for (auto c : p) {
			if (c == 'R') {
				flag = 1 - flag;
			}
			else {
				if (DQ.empty()) {
					chk = true;
					break;
				}
				if (flag) DQ.pop_back();
				else DQ.pop_front();
			}
		}
		if (chk)
			cout << "error\n";
		else {
			if (flag) reverse(DQ.begin(), DQ.end());
			print_result(DQ);
		}
	}
	return 0;
}