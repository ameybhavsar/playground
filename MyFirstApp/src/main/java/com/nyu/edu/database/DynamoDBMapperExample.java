package com.nyu.edu.database;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.TableCollection;
import com.amazonaws.services.dynamodbv2.model.*;
import com.nyu.edu.services.api.Student;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Amey on 9/18/2016.
 */
public class DynamoDBMapperExample {

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static String localHost = "http://localhost:8000";

    public static AmazonDynamoDBClient initDynamoDBClient() {
        AmazonDynamoDBClient client = null;
        try {
            client = new AmazonDynamoDBClient(new ProfileCredentialsProvider());
            client.setEndpoint(localHost);
        } catch (Exception e) {
            System.err.println("Initializing client failed due to following exception :: " + e);
            System.err.println(e.getMessage());
        }
        return client;
    }

    public static DynamoDBMapper getDynamoDBMapper() {
        DynamoDBMapper mapper = new DynamoDBMapper(initDynamoDBClient());
        return mapper;
    }

    public static DynamoDB getDynamoDB() {
        DynamoDB dynamoDB = new DynamoDB(initDynamoDBClient());
        return dynamoDB;
    }

    private static void testCRUDOperations() {
        DynamoDBMapper mapper = getDynamoDBMapper();
        Student student = new Student();
        student.setId(1);
        student.setName("Amey Bhavsar");
        student.setGender("Male");
        student.setEmail("abc@gmail.com");
        student.setPicture(null);
        mapper.save(student);
        System.out.println("Saving the student table.");
    }

    static void createExampleTable(String tableName) {
        try {
            DynamoDB dynamoDB = getDynamoDB();
            ArrayList<AttributeDefinition> attributeDefinitions = new ArrayList<>();
            attributeDefinitions.add(new AttributeDefinition()
                    .withAttributeName("Id")
                    .withAttributeType("N"));

            ArrayList<KeySchemaElement> keySchema = new ArrayList<>();
            keySchema.add(new KeySchemaElement()
                    .withAttributeName("Id")
                    .withKeyType(KeyType.HASH)); //Partition key

            CreateTableRequest request = new CreateTableRequest()
                    .withTableName(tableName)
                    .withKeySchema(keySchema)
                    .withAttributeDefinitions(attributeDefinitions)
                    .withProvisionedThroughput(new ProvisionedThroughput()
                            .withReadCapacityUnits(5L)
                            .withWriteCapacityUnits(6L));

            System.out.println("Issuing CreateTable request for " + tableName);
            Table table = dynamoDB.createTable(request);

            System.out.println("Waiting for " + tableName
                    + " to be created...this may take a while...");
            table.waitForActive();

            getTableInformation(tableName, dynamoDB);

        } catch (Exception e) {
            System.err.println("CreateTable request failed for " + tableName);
            System.err.println(e.getMessage());
        }

    }

    static void getTableInformation(String tableName, DynamoDB dynamoDB) {
        System.out.println("Describing " + tableName);
        TableDescription tableDescription = dynamoDB.getTable(tableName).describe();
        System.out.format("Name: %s:\n" + "Status: %s \n"
                        + "Provisioned Throughput (read capacity units/sec): %d \n"
                        + "Provisioned Throughput (write capacity units/sec): %d \n",
                tableDescription.getTableName(),
                tableDescription.getTableStatus(),
                tableDescription.getProvisionedThroughput().getReadCapacityUnits(),
                tableDescription.getProvisionedThroughput().getWriteCapacityUnits());
    }

    static void listMyTables() {
        DynamoDB dynamoDB = getDynamoDB();
        TableCollection<ListTablesResult> tables = dynamoDB.listTables();
        Iterator<Table> iterator = tables.iterator();

        System.out.println("Listing table names");

        while (iterator.hasNext()) {
            Table table = iterator.next();
            System.out.println(table.getTableName());
        }
    }

    public static void insertRecord(DynamoDBMapper dbMapper, Student student) {
        dbMapper.save(student);
    }




    // Testin purpose only
    public static void main(String[] args) {
        //createExampleTable("student");
        listMyTables();

        //testCRUDOperations();
    }
}
