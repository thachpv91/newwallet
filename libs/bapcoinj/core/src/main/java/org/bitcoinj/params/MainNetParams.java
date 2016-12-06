/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bitcoinj.params;

import org.bitcoinj.core.CoinDefinition;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Sha256Hash;
import org.bitcoinj.core.Utils;

import static com.google.common.base.Preconditions.checkState;

/**
 * Parameters for the main production network on which people trade goods and services.
 */
public class MainNetParams extends NetworkParameters {
    public MainNetParams() {
        super();
        interval = INTERVAL;
        targetTimespan = TARGET_TIMESPAN;
        maxTarget = CoinDefinition.proofOfWorkLimit;
        dumpedPrivateKeyHeader = 128 + CoinDefinition.AddressHeader;
        addressHeader = CoinDefinition.AddressHeader;
        p2shHeader = CoinDefinition.p2shHeader;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        port = CoinDefinition.Port;
        packetMagic = CoinDefinition.PacketMagic;

        genesisBlock.setDifficultyTarget(CoinDefinition.genesisBlockDifficultyTarget);
        genesisBlock.setTime(CoinDefinition.genesisBlockTime);
        genesisBlock.setNonce(CoinDefinition.genesisBlockNonce);
        id = ID_MAINNET;
        subsidyDecreaseBlockCount = CoinDefinition.subsidyDecreaseBlockCount;
        spendableCoinbaseDepth = CoinDefinition.spendableCoinbaseDepth;

        String genesisHash = genesisBlock.getHashAsString();
        System.out.println(" MainNetParam: ******* genesisHash = " + genesisHash);
        System.out.println(" MainNetParam: ******* CoinDefinition.genesisHash" + CoinDefinition.genesisHash);
        checkState(genesisHash.equals(CoinDefinition.genesisHash),
                genesisHash);


        CoinDefinition.initCheckpoints(checkpoints);

        dnsSeeds = CoinDefinition.dnsSeeds;

        // httpSeeds = null; 
        /*new HttpDiscovery.Details[] {
                // Mike Hearn
                new HttpDiscovery.Details(
                        ECKey.fromPublicOnly(Utils.HEX.decode("027a79143a4de36341494d21b6593015af6b2500e720ad2eda1c0b78165f4f38c4")),
                        URI.create("http://main.seed.vinumeris.com/peers")
                ),
                // Andreas Schildbach
                new HttpDiscovery.Details(
                        ECKey.fromPublicOnly(Utils.HEX.decode("0238746c59d46d5408bf8b1d0af5740fe1a6e1703fcb56b2953f0b965c740d256f")),
                        URI.create("http://httpseed.bitcoin.schildbach.de/peers")
                )
        };*/
        /* thachpv rem, config addrSeeds in SeedPeers.java
        addrSeeds = new int[] {
                0x0eb0c35e, 0xc0a80006
        };*/
    }

    private static MainNetParams instance;
    public static synchronized MainNetParams get() {
        if (instance == null) {
            instance = new MainNetParams();
        }
        return instance;
    }

    @Override
    public String getPaymentProtocolId() {
        return PAYMENT_PROTOCOL_ID_MAINNET;
    }
}
