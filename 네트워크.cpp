//
//  네트워크.cpp
//  cpp
//
//  Created by 병욱 민 on 9/29/25.
//

#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    
    vector<int> visited(n + 1, 0);
    for (int i = 0; i < n; i++) {
        if (visited[i]) continue;
        
        queue<int> q;
        visited[i] = 1;
        q.push(i);
        
        while (!q.empty()) {
            auto cur = q.front();
            q.pop();
            
            for (int nx = 0; nx < n; nx++) {
                if (!computers[cur][nx]) continue;
                if (visited[nx]) continue;
                visited[nx] = 1;
                q.push(nx);
            }
        }
        answer++;
    }
    return answer;
}

/*
    네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미한다.
    
    컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 리턴하자.
    
*/
