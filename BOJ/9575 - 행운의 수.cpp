//
//  9575 - 행운의 수.cpp
//  cpp
//
//  Created by 민병욱 on 7/12/25.
//

#include <iostream>
#include <vector>
#include <set>

using namespace std;

#define FASTIO ios::sync_with_stdio(0); cin.tie(0);

int TC;

bool isLuckyNumber(int number) {
    while (number) {
        int remain = number % 10;
        if (remain != 5 && remain != 8) return false;
        number /= 10;
    }
    return true;
}

int main() {
    FASTIO
    cin >> TC;
    while (TC--) {
        int N, M, K;
        cin >> N;
        vector<int> A(N);
        for (int i = 0; i < N; i++) {
            cin >> A[i];
        }
        cin >> M;
        vector<int> B(M);
        for (int i = 0; i < M; i++) {
            cin >> B[i];
        }
        cin >> K;
        vector<int> C(K);
        for (int i = 0; i < K; i++) {
            cin >> C[i];
        }
        
        set<int> ans;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < K; k++) {
                    int num = A[i] + B[j] + C[k];
                    if (!isLuckyNumber(num)) continue;
                    ans.insert(num);
                }
            }
        }
        cout << ans.size() << "\n";
    }
    return 0;
}

/*
 각 자리가 5와 8로만 이뤄져 있는 수를 행운의 수라고 한다.
 정수 수열 A, B, C가 주어졌을 때 세 수열에서 각각 하나의 정수를 골라서 만들 수 있는 서로 다른 행운의 수의 개수를 구하자.
 */
