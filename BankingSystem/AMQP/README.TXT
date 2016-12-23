
See Installation instructions


                     TOPIC EXCHANGE
                     
Two queues... [ actually 3]
One queue for "built in" consumer purchasesStore
One queue for external  consumer purchasesOnline [ as well as purchasesOnlineClassic]

Has Producers for BOTH  Queues
Has listener on purchasesStore queue

AMQPClient application has listener on purchasesOnline queue


                    DIRECT EXCHANGE

One queue [directQueue]

Has Producer & Consumer[Listener]

 AMQPDirectClient application also has a Producer
                