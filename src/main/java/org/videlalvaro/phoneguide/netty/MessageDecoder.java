package org.videlalvaro.phoneguide.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.videlalvaro.phoneguide.PhoneNumber;

import java.util.List;

public class MessageDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext var1, ByteBuf in, List<Object> out) throws Exception {
        int areaCode = in.readInt();
        int prefix = in.readInt();
        int lineNumber = in.readInt();
        out.add(new PhoneNumber(areaCode, prefix, lineNumber));
    }
}
