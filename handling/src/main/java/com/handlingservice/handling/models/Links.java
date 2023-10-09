package com.handlingservice.handling.models;

import lombok.Data;

import java.util.List;

@Data
public class Links {

    private List<String> explorer;
        /*0	"https://blockchair.com/bitcoin/?from=coinpaprika"
        1	"https://blockchain.com/explorer"
        2	"https://blockstream.info/"
        3	"https://live.blockcypher.com/btc/"
        4	"https://btc.cryptoid.info/btc/"*/
    private List<String> facebook;
        /*0	"https://www.facebook.com/bitcoins/"*/
    private List<String> reddit;
        /*0	"https://www.reddit.com/r/bitcoin"*/
    private List<String> source_code;
        /*0	"https://github.com/bitcoin/bitcoin"*/
    private List<String> website;
        /*0	"https://bitcoin.org/"*/
    private List<String> youtube;
        /*0	"https://www.youtube.com/watch?v=Gc2en3nHxA4&"*/

}
