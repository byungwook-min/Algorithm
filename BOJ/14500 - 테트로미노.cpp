//
//  14500 - 테트로미노.cpp
//  Cpp
//
//  Created by 민병욱 on 2022/03/24.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define FASTIO ios::sync_with_stdio(0); cin.tie(0);
#define X first
#define Y second

int N, M;
int board[501][501];
vector<vector<pair<int, int>>> tetro;

bool isadj(pair<int, int> a, pair<int, int> b){
    if(a.X == b.X) return abs(a.Y - b.Y) == 1;
    if(a.Y == b.Y) return abs(a.X - b.X) == 1;
    return false;
}

bool isConn(vector<pair<int,int>> shape){
  bool flag = false;
  for(int i = 0; i < 4; i++){
    int cnt = 0;
    for(int j = 0; j < 4; j++)
      if(isadj(shape[i], shape[j])) cnt++;
    
    if(cnt == 0) return false;
    if(cnt >= 2) flag = true;
  }
  return flag;
}

int main(){
    FASTIO;
    cin >> N >> M;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            cin >> board[i][j];
        }
    }
    vector<int> brute(16);
    fill(brute.begin() + 12, brute.end(), 1);
    do{
        vector<pair<int, int>> shape;
        for(int i = 0; i < 16; i++){
            if(brute[i] == 1)
                shape.push_back({i / 4, i % 4});
        }
        if(isConn(shape)) tetro.push_back(shape);
    }
    while(next_permutation(brute.begin(), brute.end()));
    
    int ans = 0;
    for(int i = 0; i <= N - 4; i++){
        for(int j = 0; j <= M - 4; j++){
            for(auto shape: tetro){
                int tot = 0;
                for(auto c : shape){
                    tot += board[i + c.X][j + c. Y];
                }
                ans = max(tot, ans);
            }
        }
    }
    cout << ans;
    return 0;
}
