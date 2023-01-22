package workspaces.test;
import java.util.*;
public class Main{
/*5 5
#S###
#...#
###.#
#....
###G#

정답 :6
*/

	//미로 탈출 로봇 :로봇이 출발점에서 도착점까지 가장 빨리 이동할 경우 걸리는 시간을 구하기
	 int W, H;//지도 가로, 세로 크기
	 int sh, sw, eh, ew;
	 char map[][];//지도정보[세로(h)][가로(w)]
	 int visited[][];
     class Que {
    	 int h,w,t;
    	 Que(){h=w=t=0;}
    	 Que(int h, int w, int t){
    		 this.h=h; this.w=w; this.t=t;
    	 }
    	 
    	 
     }
	    
	    static int sol;
	    int BFS() {
	    	int dh[]= {-1, 1, 0, 0};
	    	int dw[]= {0, 0, -1, 1};
	    	Queue <Que> que = new ArrayDeque<>();
	    	que.offer(new Que(sh, sw, 4));
	    	visited = new int[H+2][W+2];
	    	visited[sh][sw] = 1;
	    	
	    	while(!que.isEmpty()) {
	    		Que cur = que.poll();
	    		if( (cur.h == eh)&&(cur.w == ew)) return cur.t;
	    		for(int i = 0; i <4; i++) {
	    			int nh = cur.h + dh[i];
	    			int nw = cur.w + dw[i];
	    			if((nh<0)||(nh >H)||(nw<0)||(nw > W)) continue;
	    			if(map[nh][nw]=='#')continue;
	    			if(visited[nh][nw] == 1) continue;
	    			que.offer(new Que(nh, nw, cur.t+1));
	    			visited[nh][nw] =1;
	    			
	    		}
	    	}
	    	
	    	return -1;
	    }
	    void InputData(){
	        Scanner in = new Scanner(System.in);
	        W = in.nextInt(); H = in.nextInt();
	        //sw = in.nextInt(); sh = in.nextInt(); ew = in.nextInt(); eh = in.nextInt();
	        map = new char [H+10][W+10];
	        for (int i=1; i<=H; i++){//세로 인덱스
	            map[i] = in.next().toCharArray(); 
	        }
	        in.close();
	        for(int i=1; i<=W; i++) {
	        	for(int j = 1; i<=H; i++) {
	        		if(map[i][j]=='S') {
	        			sh=i;
	        			sw=j;
	        			
	        		}
	        		if(map[i][j]=='G') {
	        			eh=i;
	        			ew=j;
	        		}
	        	}
	        }
	        
	    }
	    
	    public static void main(String[] args) {
	        Main m = new Main();
	        m.InputData();
	        sol = m.BFS();
	        System.out.println(sol);
	    }

}
