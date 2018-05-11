//同步容器中的方法是用synchronized进行同步，必然会影响到其执行的性能，同时容器并不一定能做到完全的线程安全，可以用并发
//容器取代他；并发容器简称J.U.C，具体看com.cq.example.concurrent下的东西