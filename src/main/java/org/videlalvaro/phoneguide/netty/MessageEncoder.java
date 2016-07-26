package org.videlalvaro.phoneguide.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.videlalvaro.phoneguide.PhoneNumber;

public class MessageEncoder extends MessageToByteEncoder<PhoneNumber> {
    @Override
    protected void encode(ChannelHandlerContext ctx, PhoneNumber phoneNumber, ByteBuf out) {
        out.writeInt(phoneNumber.getAreaCode());
        out.writeInt(phoneNumber.getPrefix());
        out.writeInt(phoneNumber.getLineNumber());
    }
}
