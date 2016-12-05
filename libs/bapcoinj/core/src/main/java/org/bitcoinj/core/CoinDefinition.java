package org.bitcoinj.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: HashEngineering
 * Date: 8/13/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "bapcoin";
    public static final String coinTicker = "BAP";
    public static final String coinURIScheme = "bapcoin";
    //public static final String cryptsyMarketId = "26";
    //public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START = "6";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[L]";
    public static final String PATTERN_PRIVATE_KEY_START_TESTNET = "9";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED_TESTNET = "c";

    public static String lowerCaseCoinName() { return coinName.toLowerCase(); }

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;


    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://dgc.blockr.io/";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/info/";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/info/";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/info/";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = BLOCKEXPLORER_BASE_URL_PROD;

    public static final String DONATION_ADDRESS = "DPdbL3n3Y3ypwVEvY3wABmpbjsd3AVqm5M";  //HashEngineering donation DGC address

    public static final String UNSPENT_API_URL = "http://dgc.blockr.io/api/v1/address/unspent/";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Blockr;

    enum CoinHash {
        SHA256,
        scrypt,
    };
    public static final CoinHash coinPOWHash = CoinHash.scrypt;

    public static boolean checkpointFileSupport = true;
    public static int checkpointDaysBack = 21;
    //Original Values
    public static final int TARGET_TIMESPAN_0 = (int)(6 * 60 * 3 * 20);  // 3.5 days per difficulty cycle, on average.
    public static final int TARGET_SPACING_0 = (int)(1 * 20);  // 20 seconds per block.
    public static final int INTERVAL_0 = TARGET_TIMESPAN_0 / TARGET_SPACING_0;  //1080 blocks

    public static final int TARGET_TIMESPAN_1 = (int)(108 * 20);  // 36 minutes per difficulty cycle, on average.
    public static final int TARGET_SPACING_1 = (int)(1 * 20);  // 20 seconds per block.
    public static final int INTERVAL_1 = TARGET_TIMESPAN_1 / TARGET_SPACING_1;  //108 blocks

    //public static final int TARGET_TIMESPAN = (int)(108 * 40);  // 72 minutes per difficulty cycle, on average.
    //public static final int TARGET_SPACING = (int)(1 * 40);  // 40 seconds per block.
    //public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //108 blocks
    /*
    static const int64 nTargetTimespan = 5 * 60; // Hanhcoin: 3.5 days
static const int64 nTargetSpacing = 30; // Hanhcoin: 2.5 minutes
    */
    public static final int TARGET_TIMESPAN = (int)(5 * 60);  // 3.5 days per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(1 * 30);  // 25 seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //1080 blocks

    private static int nDifficultySwitchHeight = 476280;    //retarget every 108 instead of 1080 blocks; adjust by +100%/-50% instead of +400/-75%
    private static int nInflationFixHeight = 523800;        //increase block time to 40 from 20 seconds; decrease reward from 20 to 15 DGC
    private static int nDifficultySwitchHeightTwo = 625800; //retarget adjust changed
    public static final int V3_FORK = 1028000;
    public static final int MAX_BLOCK_ALGO_COUNT = 3;



    public static final int getInterval(int height, boolean testNet) {
        if(height < nDifficultySwitchHeight)
            return INTERVAL_0;    //1080
        else if(height < nInflationFixHeight)
            return INTERVAL_1;    //108
        else
            return INTERVAL;      //108
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL_0;    //1080

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
        if(height < nDifficultySwitchHeight)
            return TARGET_TIMESPAN_0;  //3.5 days
        else if(height < nInflationFixHeight)
            return TARGET_TIMESPAN_1;  //36 min
        else
            return TARGET_TIMESPAN;    //72 min
    }
    public static int getMaxTimeSpan(int value, int height, boolean testNet)
    {
        if(height < nDifficultySwitchHeight)
            return value * 4;
        else if(height < nInflationFixHeight)
            return value * 2;
        else
            return value * 75 / 60;
    }
    public static int getMinTimeSpan(int value, int height, boolean testNet)
    {
        if(height < nDifficultySwitchHeight)
            return value / 4;
        else if(height < nInflationFixHeight)
            return value / 2;
        else
            return value * 55 / 73;
    }
    public static int spendableCoinbaseDepth = 100; //main.h: static const int COINBASE_MATURITY
    public static final int MAX_MONEY = 84000000;//.multiply(Utils.COIN);                 //main.h:  MAX_MONEY  84000000 * 100000000
    //public static final String MAX_MONEY_STRING = "200000000";     //main.h:  MAX_MONEY

    public static final Coin DEFAULT_MIN_TX_FEE = Coin.valueOf(10000000);   // MIN_TX_FEE
    public static final Coin DUST_LIMIT = Coin.valueOf(1000000); //main.h CTransaction::GetMinFee        0.01 coins

    public static final int PROTOCOL_VERSION = 70002;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 209;        //version.h MIN_PROTO_VERSION - eliminate 60001 which are on the wrong fork
    public static final int INIT_PROTO_VERSION = 209;            //version.h

    public static final int BLOCK_CURRENTVERSION = 1;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = false; //Requires PROTOCOL_VERSION 70000 in the client
    public static boolean supportsIrcDiscovery() {
        return PROTOCOL_VERSION <= 70000;
    }
/*
        return testnet ? 39333 : 29333;
    */
    public static final int Port    = 29333;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 39333;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    /*
            PUBKEY_ADDRESS = 48, // Hanhcoin addresses start with L
        SCRIPT_ADDRESS = 5,
        PUBKEY_ADDRESS_TEST = 111,
        SCRIPT_ADDRESS_TEST = 196,
    */
    public static final int AddressHeader = 48;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 5;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final boolean allowBitcoinPrivateKey = true; //for backward compatibility with previous version of digitalcoin
    public static final long PacketMagic = 0xfbc0b6db;      //0xfb, 0xc0, 0xb6, 0xdb

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1479086934L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (957819);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "32faf033cd528f7c245f864b5f64d7b1f84b93be8105a110311b03365870d7fb"; //main.cpp: hashGenesisBlock
    static public int genesisBlockValue = 50;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    static public String genesisTxInBytes = "04ffff001d0104144269727468646179206f662048616e68436f696e";   //"Digitalcoin, A Currency for a Digital Age"
    static public String genesisTxOutBytes = "040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "192.168.0.7",
            "192.168.0.4",
            "192.168.0.6",
            "192.168.0.9"
     };

    public static int minBroadcastConnections = 1;   //0 for default; we need more peers.

    //
    // TestNet - digitalcoin - not tested
    //
    public static final boolean supportsTestNet = false;
    public static final int testnetAddressHeader = 111;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 196;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0xfcc1b7dc;      //0xfc, 0xc1, 0xb7, 0xdc
    public static final String testnetGenesisHash = "5e039e1ca1dbf128973bf6cff98169e40a1b194c3b91463ab74956f413b2f9c8";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 999999L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (99999);                         //main.cpp: LoadBlockIndex





    public static final boolean usingNewDifficultyProtocol(int height)
    { return height >= nDifficultySwitchHeight;}

    public static final boolean usingInflationFixProtocol(int height)
    { return height >= nInflationFixHeight;}

    //main.cpp GetBlockValue(height, fee)
    /*public static final BigInteger GetBlockReward(int height)
    {
        int COIN = 1;
        BigInteger nSubsidy = Utils.toNanoCoins(15, 0);

        if(height < 1080)
        {
            nSubsidy = Utils.toNanoCoins(2, 0); //2
        }
        else if(height < 2160)
        {
            nSubsidy   = Utils.toNanoCoins(1, 0); //2
        }
        else if(height < 3240)
        {
            nSubsidy   = Utils.toNanoCoins(2, 0); //2
        }
        else if(height < 4320)
        {
            nSubsidy  = Utils.toNanoCoins(5, 0); //5
        }
        else if(height < 5400)
        {
            nSubsidy  = Utils.toNanoCoins(8, 0); //8
        }
        else if(height < 6480)
        {
            nSubsidy = Utils.toNanoCoins(11, 0); //11
        }
        else if(height < 7560)
        {
            nSubsidy  = Utils.toNanoCoins(14, 0); //14
        }
        else if(height < 8640)
        {
            nSubsidy = Utils.toNanoCoins(17, 0); //17
        }
        else if(height < 523800)
        {
            nSubsidy = Utils.toNanoCoins(20, 0); //20
        }
        else if(height >= V3_FORK)
        {
            nSubsidy = Utils.toNanoCoins(5, 0); //5;
        }
        else
        {
            return nSubsidy.shiftRight(height / subsidyDecreaseBlockCount);
        }
        return nSubsidy;
    } */

    
    public static int subsidyDecreaseBlockCount = 840000;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    public static BigInteger [] proofOfWorkLimits = new BigInteger[] {
            proofOfWorkLimit,proofOfWorkLimit,proofOfWorkLimit,proofOfWorkLimit,proofOfWorkLimit };

    public static BigInteger getProofOfWorkLimit(int algo)
    {
        return proofOfWorkLimits[algo];
    }

    static public String[] testnetDnsSeeds = new String[] {
          "not supported"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "04016c44069c3152982413d3ba3bf262a3a4d3ddad859ba78e0d744f5c67c2205d2aa2122e6c62b6310dad2d1e2f7e39028455ff1dbb26511c60fc96c8b4560c43";
    public static final String TESTNET_SATOSHI_KEY = "";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.digitalcoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.digitalcoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.digitalcoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put( 0, new Sha256Hash("32faf033cd528f7c245f864b5f64d7b1f84b93be8105a110311b03365870d7fb"));
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "DPHYTSm3f96dHRY3VG1vZAFC1QrEPkEQnt";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "QU1rjHbrdJonVUgjT7Mncw7PEyPv3fMPvaGXp9EHDs1uzdJ98hUZ";

}
