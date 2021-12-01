/*
 * Copyright 2021 4Paradigm
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com._4paradigm.openmldb.taskmanager.config;

import java.util.Properties;

public class TaskManagerConfig {
    public static String HOST = "127.0.0.1";
    public static int PORT = 9902;
    public static int WORKER_THREAD = 4;
    public static int IO_THREAD = 4;
    public static String ZK_CLUSTER;
    public static String ZK_ROOTPATH;
    public static int ZK_SESSION_TIMEOUT = 5000;
    public static String SPARK_MASTER;
    public static String BATCHJOB_JAR_PATH;
    public static String SPARK_YARN_JARS;
    public static String SPARK_HOME;

    static {
        try {
            Properties properties = new Properties();
            properties.load(TaskManagerConfig.class.getClassLoader().getResourceAsStream("taskmanager.properties"));
            HOST = properties.getProperty("server.host", "127.0.0.1");
            PORT = Integer.parseInt(properties.getProperty("server.port", "9902"));
            WORKER_THREAD = Integer.parseInt(properties.getProperty("server.worker_threads", "4"));
            IO_THREAD = Integer.parseInt(properties.getProperty("server.io_threads", "4"));
            ZK_SESSION_TIMEOUT = Integer.parseInt(properties.getProperty("zookeeper.session_timeout", "5000"));
            ZK_CLUSTER = properties.getProperty("zookeeper.cluster");
            ZK_ROOTPATH = properties.getProperty("zookeeper.root_path");
            SPARK_MASTER = properties.getProperty("spark.master", "yarn");
            BATCHJOB_JAR_PATH = properties.getProperty("batchjob.jar.path");
            SPARK_YARN_JARS = properties.getProperty("spark.yarn.jars");
            SPARK_HOME = properties.getProperty("spark.home");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
