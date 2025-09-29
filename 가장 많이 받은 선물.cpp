//
//  가장 많이 받은 선물.cpp
//  cpp
//
//  Created by 병욱 민 on 9/29/25.
//

#include <string>
#include <vector>
#include <sstream>
#include <iostream>
#include <unordered_map>
#include <algorithm>

using namespace std;

int solution(vector<string> friends, vector<string> gifts) {
    int n = (int)friends.size();

    unordered_map<string,int> idx;
    idx.reserve(n * 2);
    for (int i = 0; i < n; ++i) idx[friends[i]] = i;

    vector<vector<int>> cnt(n, vector<int>(n, 0));
    vector<int> score(n, 0);

    for (auto& gift : gifts) {
        istringstream iss(gift);
        string from, to;
        iss >> from >> to;
        int a = idx[from], b = idx[to];
        cnt[a][b] += 1;
        score[a] += 1;
        score[b] -= 1;
    }

    vector<int> nextReceive(n, 0);
    for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) {
            int ab = cnt[i][j];
            int ba = cnt[j][i];
            if (ab > ba) {
                nextReceive[i] += 1;
                continue;
            }
            if (ba > ab) {
                nextReceive[j] += 1;
                continue;
            }
            if (score[i] > score[j]) nextReceive[i] += 1;
            else if (score[j] > score[i]) nextReceive[j] += 1;
        }
    }
    return *max_element(nextReceive.begin(), nextReceive.end());
}

/*
    친구들이 이번 달까지 선물을 주고받은 기록을 바탕으로 다음 달에 누가 선물을 많이 받을지 예측하려고 한다.
    
    두 사람이 선물을 주고 받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물은 준 사람이 다음 달에 선물을 하나 받는다.
    두 사람이 선물을 주고 받은 기록이 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받는다.
    - 선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값이다.
    - 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않는다.
    
    설명한 규칙대로 다음 달에 선물을 주고받을 때, 선물을 가장 많이 받을 친구가 받을 선물의 수를 알아보자.
    1. 두 사람 사이에 선물 누가 줄지 계산
    2. 선물 지수 계산 배열 gifts 순회하면서 [A][B]++;, [B][A]--;, scores로 선물 점수 따로 계산
*/

