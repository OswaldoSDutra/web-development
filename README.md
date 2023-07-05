# Building an AWS API

Sources:

https://www.baeldung.com/java-aws-lambda \
https://www.baeldung.com/aws-lambda-dynamodb-java \
https://www.baeldung.com/aws-lambda-api-gateway \
https://www.baeldung.com/aws-serverless \
https://www.baeldung.com/java-enterprise-aws-lambda

1. Configuring de aws cli to the local stack address

    1. `aws --endpoint-url=http://localhost:4566 kinesis list-streams`
    2. `$ aws configure --profile default` 

>AWS Access Key ID [****************test]: test  
AWS Secret Access Key [****************test]: test  
Default region name [us-east-1]: us-east-1

2. Upload the code to a bucket
   1. `awslocal s3api create-bucket --bucket todo-bucket`
   2. `awslocal s3api put-object --bucket todo-bucket`  
   `--key todo-api-1.0-SNAPSHOT.jar`  
   `--body .\target\todo-api-1.0-SNAPSHOT.jar`


3. Create a template file for infrastructure setup
   1. Create a "infra.yaml" file at the resources folder
   2. `awslocal cloudformation deploy --template-file .\src\main\resources\infra\infra.yaml --stack-name todo-stack`

> Obs.: It is possible to change the enviroment at runtime, for example:  
`awslocal cloudformation deploy`  
`--template-file .\src\main\resources\infra\infra.yaml`   
`--parameter-overrides "EnvironmentName=test"`  
`--stack-name todo-stack`

4. Check the dynamodb table
    1. `awslocal dynamodb list-tables --endpoint-url http://localhost:4566`


5. Get the API Gateway information
    1. `awslocal cloudformation describe-stack-resources --stack-name todo-stack`
 
>Find the API Id:  
"PhysicalResourceId": "6p5rftscrb",  
"ResourceType": "AWS::ApiGateway::RestApi"    
    
> Find the API StageId:  
    "PhysicalResourceId": "Prod",  
    "ResourceType": "AWS::ApiGateway::Stage",

6. Check the API resources

    1. `awslocal apigateway get-resources --rest-api-id ia0449h6qw`
    
    >Where: awslocal apigateway get-resources --rest-api-id <RestApi-PhysicalResourceId>

7. Call the rources
   1. `curl -X POST http://2snemyvdy2.execute-api.localhost.localstack.cloud:4566/Prod/task/` \
   `-d '{"title":"go grocery shooping"}' `   
   `-H "Content-Type: application/json" `
   2. `curl -X GET http://2snemyvdy2.execute-api.localhost.localstack.cloud:4566/Prod/task/aa526d45-b979-4a02-87b6-9557cb2b7387`

> Where:	curl -X GET http://<RestApi-PhysicalResourceId>.execute-api.localhost.localstack.cloud:4566/<Stage-PhysicalResourceId>/task/<DynamoDb-Taks-Id>

8. Check DynamoDb data
   1. `awslocal dynamodb scan --table-name Task --endpoint-url http://localhost:4566`


9. Check lambda logs
   1. `awslocal logs describe-log-groups`

>Find log group name:   
`logGroupName": "/aws/lambda/todo-stack-CreateTaskFunction-ec82a92f"`

   2. List group's streams \
   `awslocal logs describe-log-streams --log-group-name /aws/lambda/todo-stack-CreateTaskFunction-ec82a92f`
		
>Find stream name \
  `gStreamName": "2023/06/07/[$LATEST]1897bf7f3bd70548259b27e609e801e2"`

   3. Get stream's logs  
   `awslocal logs get-log-events`  
   `--log-group-name /aws/lambda/todo-stack-CreateTaskFunction-ec82a92f`  
   `--log-stream-name '2023/06/07/[$LATEST]153544aa9bf86b4ba952ce0a84657448'`


10. Delete the stack
    1. `awslocal cloudformation delete-stack --stack-name todo-stack'` 




