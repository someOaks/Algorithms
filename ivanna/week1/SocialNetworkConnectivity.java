import edu.princeton.cs.algs4.UF;

/**
 *    #1 Social network connectivity.

 Given a social network containing n members
 and a log file containing m timestamps
 at which times pairs of members formed friendships,
 design an algorithm to determine the earliest time
 at which all members are connected
 (i.e., every member is a friend of a friend of a friend ... of a friend).

 Assume that the log file is sorted by timestamp
 and that friendship is an equivalence relation.
 The running time of your algorithm should be m log n or better
 and use extra space proportional to n.
 */
public class SocialNetworkConnectivity {

    public static void main(String[] args) {
        Connection[] connections = {
                new Connection(1, 0, 1),
                new Connection(2, 1, 2),
                new Connection(3, 0, 3),
                new Connection(4, 2, 3)
        };


        UF network = new UF(4);

        for (int i = 0; i < connections.length; i++) {
            Connection connection = connections[i];
            network.union(connection.p1, connection.p2);
            System.out.println(i + " p1 " + connection.p1 + " p2 " + connection.p2 );

            if (network.count() == 1){
                System.out.println(connection.time);
                return;
            }

        }
    }

}

/*
* n = 4 (A B C D)
*
* 1, A, B
* 2, B, C
* 3, A, D
* 4, C, D
*
*
*
*  union with 4 nodes
*  connect 0-1
*  A-B C D  (3)
*
*  connect 1-2
*  A-B-C D (2)
*
*  connect 0-3
*  A-B-C D (1)
*   \___/
*
*  return 7
* */