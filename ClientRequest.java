import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

class ClientRequest
{
    private final String clientName;
    private final int priority;
    private final long timestamp;
    public ClientRequest(String clientName, int priority)
    {
        this.clientName = clientName;
        this.priority = priority;
        this.timestamp = System.currentTimeMillis();
    }
    public String getClientName()
    {
        return clientName;
    }
    public int getPriority()
    {
        return priority;
    }
    public long getTimestamp()
    {
        return timestamp;
    }
    @Override
    public String toString()
    {
        return "ClientRequest{" +
                "clientName='" + clientName + '\'' +
                ", priority=" + priority +
                ", timestamp=" + timestamp +
                '}';
    }
}
class ServerQueue
{
    private final Queue<ClientRequest> requestQueue;
    private final Queue<ClientRequest> requestLog;
    public ServerQueue()
    {
        this.requestQueue = new PriorityQueue<>(Comparator.comparingInt(ClientRequest::getPriority).reversed());
        this.requestLog = new LinkedList<>();
    }
    public void addRequest(ClientRequest request)
    {
        requestQueue.offer(request);
        requestLog.offer(request);
        System.out.println("Added a request from " + request.getClientName() + " with priority " + request.getPriority());
    }
    public ClientRequest processNextRequest()
    {
        ClientRequest nextRequest = requestQueue.poll();
        if (nextRequest != null)
        {
            System.out.println("Processing a request from " + nextRequest.getClientName() + " with priority " + nextRequest.getPriority());
        }
        else
        {
            System.out.println("The queue is empty");
        }
        return nextRequest;
    }
    public void printRequestLog()
    {
        System.out.println("Request history: ");
        for (ClientRequest request : requestLog)
        {
            System.out.println(request);
        }
    }
    public static void main(String[] args)
    {
        ServerQueue serverQueue = new ServerQueue();
        serverQueue.addRequest(new ClientRequest("Client 1", 2));
        serverQueue.addRequest(new ClientRequest("Client 2", 5));
        serverQueue.addRequest(new ClientRequest("Client 3", 1));
        serverQueue.addRequest(new ClientRequest("Client 4", 3));
        serverQueue.processNextRequest();
        serverQueue.processNextRequest();
        serverQueue.processNextRequest();
        serverQueue.processNextRequest();
        serverQueue.printRequestLog();
    }
}
