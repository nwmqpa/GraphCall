# GraphCall

### License

This project is licensed under the GNU GPLv3 License

### Introduction

Back when I first discovered GraphQL, I started using it for y data driven projects.

But I was in shock when I saw that no good java framework was able to make a decent request.

I decided to make one then...

### Use case


```java
import com.nwmqpa.graphcall.requests.Query;

public class Main {
    
    public int main(String argv[]) {
        Query query = new Query();
        query.addNode("hero")
                .addNode("friends")
                .addEdge("friendsName")
                .buildNode()
                .addEdge("name");
        System.out.println(query.compile);
        
        Request request = new Request(query.compile());
        Result result = request.send(new URL("http://api.example.com/graphql/"));
        System.out.println(result.data);
        return (0);
    }
}
```

Resolves to ...

```graphQL
query {
  hero {
    friends {
      friendsName
    }
    name
  }
}

{"data": {
    "hero": [
        {
            "friends": [
                {
                    "friendsName": "Leia"
                },
                {
                    "firendsName": "Han"
                }
            ],
            "name": "Luke"
        }
     ]
    }
}
```



### TODO

* Make mutation resolves correcty

* Implement queries arguments.

* Implements fragments and name queries.

### Credits

Thomas Nicollet (@nwmqpa)
