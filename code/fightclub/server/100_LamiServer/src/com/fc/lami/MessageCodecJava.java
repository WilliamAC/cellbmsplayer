package com.fc.lami;

import java.io.IOException;
import com.net.mutual.MutualMessage;
import com.net.mutual.MutualMessageCodec;
import com.net.NetDataInput;
import com.net.NetDataOutput;
import com.net.NetDataTypes;


/**
 * 此代码为自动生成。不需要在此修改。若有错误，请修改代码生成器。
 */
public class MessageCodecJava implements MutualMessageCodec
{
	public String getVersion() {
		return "Fri Jul 01 09:59:00 CST 2011";
	}

	public void readExternal(MutualMessage msg, NetDataInput in) throws IOException 
	{
		if (msg.getClass().equals(com.fc.lami.Messages.AutoEnterRequest.class)) {
			_r((com.fc.lami.Messages.AutoEnterRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.AutoEnterResponse.class)) {
			_r((com.fc.lami.Messages.AutoEnterResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.CardData.class)) {
			_r((com.fc.lami.Messages.CardData)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.CardStackChangeNotify.class)) {
			_r((com.fc.lami.Messages.CardStackChangeNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.DeskData.class)) {
			_r((com.fc.lami.Messages.DeskData)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.EnterDeskAsVisitorRequest.class)) {
			_r((com.fc.lami.Messages.EnterDeskAsVisitorRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.EnterDeskAsVisitorResponse.class)) {
			_r((com.fc.lami.Messages.EnterDeskAsVisitorResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.EnterDeskNotify.class)) {
			_r((com.fc.lami.Messages.EnterDeskNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.EnterDeskRequest.class)) {
			_r((com.fc.lami.Messages.EnterDeskRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.EnterDeskResponse.class)) {
			_r((com.fc.lami.Messages.EnterDeskResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.EnterRoomNotify.class)) {
			_r((com.fc.lami.Messages.EnterRoomNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.EnterRoomRequest.class)) {
			_r((com.fc.lami.Messages.EnterRoomRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.EnterRoomResponse.class)) {
			_r((com.fc.lami.Messages.EnterRoomResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.ExitRoomNotify.class)) {
			_r((com.fc.lami.Messages.ExitRoomNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.ExitRoomRequest.class)) {
			_r((com.fc.lami.Messages.ExitRoomRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.ExitRoomResponse.class)) {
			_r((com.fc.lami.Messages.ExitRoomResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.FreshRoomNotify.class)) {
			_r((com.fc.lami.Messages.FreshRoomNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GameOverNotify.class)) {
			_r((com.fc.lami.Messages.GameOverNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GameOverToRoomNotify.class)) {
			_r((com.fc.lami.Messages.GameOverToRoomNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GameResetNotify.class)) {
			_r((com.fc.lami.Messages.GameResetNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GameResetRequest.class)) {
			_r((com.fc.lami.Messages.GameResetRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GameResetResponse.class)) {
			_r((com.fc.lami.Messages.GameResetResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GameStartNotify.class)) {
			_r((com.fc.lami.Messages.GameStartNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GameStartToRoomNotify.class)) {
			_r((com.fc.lami.Messages.GameStartToRoomNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GetCardNotify.class)) {
			_r((com.fc.lami.Messages.GetCardNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GetCardOverRequest.class)) {
			_r((com.fc.lami.Messages.GetCardOverRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GetCardOverResponse.class)) {
			_r((com.fc.lami.Messages.GetCardOverResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GetCardRequest.class)) {
			_r((com.fc.lami.Messages.GetCardRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GetCardResponse.class)) {
			_r((com.fc.lami.Messages.GetCardResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GetPlayerDataRequest.class)) {
			_r((com.fc.lami.Messages.GetPlayerDataRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GetPlayerDataResponse.class)) {
			_r((com.fc.lami.Messages.GetPlayerDataResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GetTimeRequest.class)) {
			_r((com.fc.lami.Messages.GetTimeRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GetTimeResponse.class)) {
			_r((com.fc.lami.Messages.GetTimeResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.KickOutNotify.class)) {
			_r((com.fc.lami.Messages.KickOutNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.LeaveDeskForceRequest.class)) {
			_r((com.fc.lami.Messages.LeaveDeskForceRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.LeaveDeskForceResponse.class)) {
			_r((com.fc.lami.Messages.LeaveDeskForceResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.LeaveDeskNotify.class)) {
			_r((com.fc.lami.Messages.LeaveDeskNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.LeaveDeskRequest.class)) {
			_r((com.fc.lami.Messages.LeaveDeskRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.LeaveDeskResponse.class)) {
			_r((com.fc.lami.Messages.LeaveDeskResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.LoginRequest.class)) {
			_r((com.fc.lami.Messages.LoginRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.LoginResponse.class)) {
			_r((com.fc.lami.Messages.LoginResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.LogoutRequest.class)) {
			_r((com.fc.lami.Messages.LogoutRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.MainMatrixChangeNotify.class)) {
			_r((com.fc.lami.Messages.MainMatrixChangeNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.MainMatrixChangeRequest.class)) {
			_r((com.fc.lami.Messages.MainMatrixChangeRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.MainMatrixChangeResponse.class)) {
			_r((com.fc.lami.Messages.MainMatrixChangeResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.MoveCardToDeskRequest.class)) {
			_r((com.fc.lami.Messages.MoveCardToDeskRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.MoveCardToDeskResponse.class)) {
			_r((com.fc.lami.Messages.MoveCardToDeskResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.MoveCardToPlayerRequest.class)) {
			_r((com.fc.lami.Messages.MoveCardToPlayerRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.MoveCardToPlayerResponse.class)) {
			_r((com.fc.lami.Messages.MoveCardToPlayerResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.OpenIceNotify.class)) {
			_r((com.fc.lami.Messages.OpenIceNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.OperateCompleteNotify.class)) {
			_r((com.fc.lami.Messages.OperateCompleteNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.PlatformUserData.class)) {
			_r((com.fc.lami.Messages.PlatformUserData)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.PlayerData.class)) {
			_r((com.fc.lami.Messages.PlayerData)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.PlayerState.class)) {
			_r((com.fc.lami.Messages.PlayerState)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.PlayerUpdateNotify.class)) {
			_r((com.fc.lami.Messages.PlayerUpdateNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.ReadyNotify.class)) {
			_r((com.fc.lami.Messages.ReadyNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.ReadyRequest.class)) {
			_r((com.fc.lami.Messages.ReadyRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.ReadyResponse.class)) {
			_r((com.fc.lami.Messages.ReadyResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.RepealSendCardNotify.class)) {
			_r((com.fc.lami.Messages.RepealSendCardNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.RepealSendCardRequest.class)) {
			_r((com.fc.lami.Messages.RepealSendCardRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.RepealSendCardResponse.class)) {
			_r((com.fc.lami.Messages.RepealSendCardResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.ResultPak.class)) {
			_r((com.fc.lami.Messages.ResultPak)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.RoomData.class)) {
			_r((com.fc.lami.Messages.RoomData)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.RoomSnapShot.class)) {
			_r((com.fc.lami.Messages.RoomSnapShot)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SpeakToChannelNotify.class)) {
			_r((com.fc.lami.Messages.SpeakToChannelNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SpeakToChannelRequest.class)) {
			_r((com.fc.lami.Messages.SpeakToChannelRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SpeakToChannelResponse.class)) {
			_r((com.fc.lami.Messages.SpeakToChannelResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SpeakToPrivateNotify.class)) {
			_r((com.fc.lami.Messages.SpeakToPrivateNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SpeakToPrivateRequest.class)) {
			_r((com.fc.lami.Messages.SpeakToPrivateRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SpeakToPrivateResponse.class)) {
			_r((com.fc.lami.Messages.SpeakToPrivateResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SpeakToPublicNotify.class)) {
			_r((com.fc.lami.Messages.SpeakToPublicNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SpeakToPublicRequest.class)) {
			_r((com.fc.lami.Messages.SpeakToPublicRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SpeakToPublicResponse.class)) {
			_r((com.fc.lami.Messages.SpeakToPublicResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SubmitRequest.class)) {
			_r((com.fc.lami.Messages.SubmitRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SubmitResponse.class)) {
			_r((com.fc.lami.Messages.SubmitResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SynchronizeRequest.class)) {
			_r((com.fc.lami.Messages.SynchronizeRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SynchronizeResponse.class)) {
			_r((com.fc.lami.Messages.SynchronizeResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.TimeOutNotify.class)) {
			_r((com.fc.lami.Messages.TimeOutNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.TurnEndNotify.class)) {
			_r((com.fc.lami.Messages.TurnEndNotify)msg, in); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.TurnStartNotify.class)) {
			_r((com.fc.lami.Messages.TurnStartNotify)msg, in); return;
		}

	}

	public void writeExternal(MutualMessage msg, NetDataOutput out) throws IOException 
	{
		if (msg.getClass().equals(com.fc.lami.Messages.AutoEnterRequest.class)) {
			_w((com.fc.lami.Messages.AutoEnterRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.AutoEnterResponse.class)) {
			_w((com.fc.lami.Messages.AutoEnterResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.CardData.class)) {
			_w((com.fc.lami.Messages.CardData)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.CardStackChangeNotify.class)) {
			_w((com.fc.lami.Messages.CardStackChangeNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.DeskData.class)) {
			_w((com.fc.lami.Messages.DeskData)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.EnterDeskAsVisitorRequest.class)) {
			_w((com.fc.lami.Messages.EnterDeskAsVisitorRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.EnterDeskAsVisitorResponse.class)) {
			_w((com.fc.lami.Messages.EnterDeskAsVisitorResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.EnterDeskNotify.class)) {
			_w((com.fc.lami.Messages.EnterDeskNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.EnterDeskRequest.class)) {
			_w((com.fc.lami.Messages.EnterDeskRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.EnterDeskResponse.class)) {
			_w((com.fc.lami.Messages.EnterDeskResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.EnterRoomNotify.class)) {
			_w((com.fc.lami.Messages.EnterRoomNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.EnterRoomRequest.class)) {
			_w((com.fc.lami.Messages.EnterRoomRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.EnterRoomResponse.class)) {
			_w((com.fc.lami.Messages.EnterRoomResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.ExitRoomNotify.class)) {
			_w((com.fc.lami.Messages.ExitRoomNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.ExitRoomRequest.class)) {
			_w((com.fc.lami.Messages.ExitRoomRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.ExitRoomResponse.class)) {
			_w((com.fc.lami.Messages.ExitRoomResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.FreshRoomNotify.class)) {
			_w((com.fc.lami.Messages.FreshRoomNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GameOverNotify.class)) {
			_w((com.fc.lami.Messages.GameOverNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GameOverToRoomNotify.class)) {
			_w((com.fc.lami.Messages.GameOverToRoomNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GameResetNotify.class)) {
			_w((com.fc.lami.Messages.GameResetNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GameResetRequest.class)) {
			_w((com.fc.lami.Messages.GameResetRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GameResetResponse.class)) {
			_w((com.fc.lami.Messages.GameResetResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GameStartNotify.class)) {
			_w((com.fc.lami.Messages.GameStartNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GameStartToRoomNotify.class)) {
			_w((com.fc.lami.Messages.GameStartToRoomNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GetCardNotify.class)) {
			_w((com.fc.lami.Messages.GetCardNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GetCardOverRequest.class)) {
			_w((com.fc.lami.Messages.GetCardOverRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GetCardOverResponse.class)) {
			_w((com.fc.lami.Messages.GetCardOverResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GetCardRequest.class)) {
			_w((com.fc.lami.Messages.GetCardRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GetCardResponse.class)) {
			_w((com.fc.lami.Messages.GetCardResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GetPlayerDataRequest.class)) {
			_w((com.fc.lami.Messages.GetPlayerDataRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GetPlayerDataResponse.class)) {
			_w((com.fc.lami.Messages.GetPlayerDataResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GetTimeRequest.class)) {
			_w((com.fc.lami.Messages.GetTimeRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.GetTimeResponse.class)) {
			_w((com.fc.lami.Messages.GetTimeResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.KickOutNotify.class)) {
			_w((com.fc.lami.Messages.KickOutNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.LeaveDeskForceRequest.class)) {
			_w((com.fc.lami.Messages.LeaveDeskForceRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.LeaveDeskForceResponse.class)) {
			_w((com.fc.lami.Messages.LeaveDeskForceResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.LeaveDeskNotify.class)) {
			_w((com.fc.lami.Messages.LeaveDeskNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.LeaveDeskRequest.class)) {
			_w((com.fc.lami.Messages.LeaveDeskRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.LeaveDeskResponse.class)) {
			_w((com.fc.lami.Messages.LeaveDeskResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.LoginRequest.class)) {
			_w((com.fc.lami.Messages.LoginRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.LoginResponse.class)) {
			_w((com.fc.lami.Messages.LoginResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.LogoutRequest.class)) {
			_w((com.fc.lami.Messages.LogoutRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.MainMatrixChangeNotify.class)) {
			_w((com.fc.lami.Messages.MainMatrixChangeNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.MainMatrixChangeRequest.class)) {
			_w((com.fc.lami.Messages.MainMatrixChangeRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.MainMatrixChangeResponse.class)) {
			_w((com.fc.lami.Messages.MainMatrixChangeResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.MoveCardToDeskRequest.class)) {
			_w((com.fc.lami.Messages.MoveCardToDeskRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.MoveCardToDeskResponse.class)) {
			_w((com.fc.lami.Messages.MoveCardToDeskResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.MoveCardToPlayerRequest.class)) {
			_w((com.fc.lami.Messages.MoveCardToPlayerRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.MoveCardToPlayerResponse.class)) {
			_w((com.fc.lami.Messages.MoveCardToPlayerResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.OpenIceNotify.class)) {
			_w((com.fc.lami.Messages.OpenIceNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.OperateCompleteNotify.class)) {
			_w((com.fc.lami.Messages.OperateCompleteNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.PlatformUserData.class)) {
			_w((com.fc.lami.Messages.PlatformUserData)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.PlayerData.class)) {
			_w((com.fc.lami.Messages.PlayerData)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.PlayerState.class)) {
			_w((com.fc.lami.Messages.PlayerState)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.PlayerUpdateNotify.class)) {
			_w((com.fc.lami.Messages.PlayerUpdateNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.ReadyNotify.class)) {
			_w((com.fc.lami.Messages.ReadyNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.ReadyRequest.class)) {
			_w((com.fc.lami.Messages.ReadyRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.ReadyResponse.class)) {
			_w((com.fc.lami.Messages.ReadyResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.RepealSendCardNotify.class)) {
			_w((com.fc.lami.Messages.RepealSendCardNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.RepealSendCardRequest.class)) {
			_w((com.fc.lami.Messages.RepealSendCardRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.RepealSendCardResponse.class)) {
			_w((com.fc.lami.Messages.RepealSendCardResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.ResultPak.class)) {
			_w((com.fc.lami.Messages.ResultPak)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.RoomData.class)) {
			_w((com.fc.lami.Messages.RoomData)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.RoomSnapShot.class)) {
			_w((com.fc.lami.Messages.RoomSnapShot)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SpeakToChannelNotify.class)) {
			_w((com.fc.lami.Messages.SpeakToChannelNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SpeakToChannelRequest.class)) {
			_w((com.fc.lami.Messages.SpeakToChannelRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SpeakToChannelResponse.class)) {
			_w((com.fc.lami.Messages.SpeakToChannelResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SpeakToPrivateNotify.class)) {
			_w((com.fc.lami.Messages.SpeakToPrivateNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SpeakToPrivateRequest.class)) {
			_w((com.fc.lami.Messages.SpeakToPrivateRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SpeakToPrivateResponse.class)) {
			_w((com.fc.lami.Messages.SpeakToPrivateResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SpeakToPublicNotify.class)) {
			_w((com.fc.lami.Messages.SpeakToPublicNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SpeakToPublicRequest.class)) {
			_w((com.fc.lami.Messages.SpeakToPublicRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SpeakToPublicResponse.class)) {
			_w((com.fc.lami.Messages.SpeakToPublicResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SubmitRequest.class)) {
			_w((com.fc.lami.Messages.SubmitRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SubmitResponse.class)) {
			_w((com.fc.lami.Messages.SubmitResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SynchronizeRequest.class)) {
			_w((com.fc.lami.Messages.SynchronizeRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.SynchronizeResponse.class)) {
			_w((com.fc.lami.Messages.SynchronizeResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.TimeOutNotify.class)) {
			_w((com.fc.lami.Messages.TimeOutNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.TurnEndNotify.class)) {
			_w((com.fc.lami.Messages.TurnEndNotify)msg, out); return;
		}
		if (msg.getClass().equals(com.fc.lami.Messages.TurnStartNotify.class)) {
			_w((com.fc.lami.Messages.TurnStartNotify)msg, out); return;
		}

	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.AutoEnterRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.AutoEnterRequest new_com_fc_lami_Messages_AutoEnterRequest(){return new com.fc.lami.Messages.AutoEnterRequest();}
	private void _r(com.fc.lami.Messages.AutoEnterRequest msg, NetDataInput in) throws IOException {
	}
	private void _w(com.fc.lami.Messages.AutoEnterRequest msg, NetDataOutput out) throws IOException {
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.AutoEnterResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.AutoEnterResponse new_com_fc_lami_Messages_AutoEnterResponse(){return new com.fc.lami.Messages.AutoEnterResponse();}
	private void _r(com.fc.lami.Messages.AutoEnterResponse msg, NetDataInput in) throws IOException {
		msg.result = in.readInt();
		msg.room = in.readExternal(com.fc.lami.Messages.RoomData.class);
	}
	private void _w(com.fc.lami.Messages.AutoEnterResponse msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.result);
		out.writeExternal(msg.room);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.CardData
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.CardData new_com_fc_lami_Messages_CardData(){return new com.fc.lami.Messages.CardData();}
	private void _r(com.fc.lami.Messages.CardData msg, NetDataInput in) throws IOException {
		msg.id = in.readInt();
		msg.point = in.readInt();
		msg.type = in.readInt();
		msg.x = in.readInt();
		msg.y = in.readInt();
		msg.isSended = in.readBoolean();
	}
	private void _w(com.fc.lami.Messages.CardData msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.id);
		out.writeInt(msg.point);
		out.writeInt(msg.type);
		out.writeInt(msg.x);
		out.writeInt(msg.y);
		out.writeBoolean(msg.isSended);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.CardStackChangeNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.CardStackChangeNotify new_com_fc_lami_Messages_CardStackChangeNotify(){return new com.fc.lami.Messages.CardStackChangeNotify();}
	private void _r(com.fc.lami.Messages.CardStackChangeNotify msg, NetDataInput in) throws IOException {
		msg.card_stack_number = in.readInt();
	}
	private void _w(com.fc.lami.Messages.CardStackChangeNotify msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.card_stack_number);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.DeskData
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.DeskData new_com_fc_lami_Messages_DeskData(){return new com.fc.lami.Messages.DeskData();}
	private void _r(com.fc.lami.Messages.DeskData msg, NetDataInput in) throws IOException {
		msg.desk_id = in.readInt();
		msg.desk_name = in.readUTF();
		msg.player_number = in.readInt();
		msg.is_started = in.readBoolean();
		msg.player_E_id = in.readInt();
		msg.player_W_id = in.readInt();
		msg.player_S_id = in.readInt();
		msg.player_N_id = in.readInt();
	}
	private void _w(com.fc.lami.Messages.DeskData msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.desk_id);
		out.writeUTF(msg.desk_name);
		out.writeInt(msg.player_number);
		out.writeBoolean(msg.is_started);
		out.writeInt(msg.player_E_id);
		out.writeInt(msg.player_W_id);
		out.writeInt(msg.player_S_id);
		out.writeInt(msg.player_N_id);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.EnterDeskAsVisitorRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.EnterDeskAsVisitorRequest new_com_fc_lami_Messages_EnterDeskAsVisitorRequest(){return new com.fc.lami.Messages.EnterDeskAsVisitorRequest();}
	private void _r(com.fc.lami.Messages.EnterDeskAsVisitorRequest msg, NetDataInput in) throws IOException {
		msg.desk_id = in.readInt();
	}
	private void _w(com.fc.lami.Messages.EnterDeskAsVisitorRequest msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.desk_id);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.EnterDeskAsVisitorResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.EnterDeskAsVisitorResponse new_com_fc_lami_Messages_EnterDeskAsVisitorResponse(){return new com.fc.lami.Messages.EnterDeskAsVisitorResponse();}
	private void _r(com.fc.lami.Messages.EnterDeskAsVisitorResponse msg, NetDataInput in) throws IOException {
		msg.result = in.readInt();
		msg.desk_id = in.readInt();
		msg.turn_interval = in.readInt();
		msg.operate_time = in.readInt();
		msg.ps = (com.fc.lami.Messages.PlayerState[])in.readExternalArray(com.fc.lami.Messages.PlayerState.class);
	}
	private void _w(com.fc.lami.Messages.EnterDeskAsVisitorResponse msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.result);
		out.writeInt(msg.desk_id);
		out.writeInt(msg.turn_interval);
		out.writeInt(msg.operate_time);
		out.writeExternalArray(msg.ps);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.EnterDeskNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.EnterDeskNotify new_com_fc_lami_Messages_EnterDeskNotify(){return new com.fc.lami.Messages.EnterDeskNotify();}
	private void _r(com.fc.lami.Messages.EnterDeskNotify msg, NetDataInput in) throws IOException {
		msg.player_id = in.readInt();
		msg.desk_id = in.readInt();
		msg.seatID = in.readInt();
	}
	private void _w(com.fc.lami.Messages.EnterDeskNotify msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.player_id);
		out.writeInt(msg.desk_id);
		out.writeInt(msg.seatID);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.EnterDeskRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.EnterDeskRequest new_com_fc_lami_Messages_EnterDeskRequest(){return new com.fc.lami.Messages.EnterDeskRequest();}
	private void _r(com.fc.lami.Messages.EnterDeskRequest msg, NetDataInput in) throws IOException {
		msg.desk_No = in.readInt();
		msg.seat = in.readInt();
	}
	private void _w(com.fc.lami.Messages.EnterDeskRequest msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.desk_No);
		out.writeInt(msg.seat);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.EnterDeskResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.EnterDeskResponse new_com_fc_lami_Messages_EnterDeskResponse(){return new com.fc.lami.Messages.EnterDeskResponse();}
	private void _r(com.fc.lami.Messages.EnterDeskResponse msg, NetDataInput in) throws IOException {
		msg.result = in.readInt();
		msg.desk_id = in.readInt();
		msg.seat = in.readInt();
		msg.turn_interval = in.readInt();
		msg.operate_time = in.readInt();
		msg.ps = (com.fc.lami.Messages.PlayerState[])in.readExternalArray(com.fc.lami.Messages.PlayerState.class);
	}
	private void _w(com.fc.lami.Messages.EnterDeskResponse msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.result);
		out.writeInt(msg.desk_id);
		out.writeInt(msg.seat);
		out.writeInt(msg.turn_interval);
		out.writeInt(msg.operate_time);
		out.writeExternalArray(msg.ps);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.EnterRoomNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.EnterRoomNotify new_com_fc_lami_Messages_EnterRoomNotify(){return new com.fc.lami.Messages.EnterRoomNotify();}
	private void _r(com.fc.lami.Messages.EnterRoomNotify msg, NetDataInput in) throws IOException {
		msg.player = in.readExternal(com.fc.lami.Messages.PlayerData.class);
	}
	private void _w(com.fc.lami.Messages.EnterRoomNotify msg, NetDataOutput out) throws IOException {
		out.writeExternal(msg.player);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.EnterRoomRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.EnterRoomRequest new_com_fc_lami_Messages_EnterRoomRequest(){return new com.fc.lami.Messages.EnterRoomRequest();}
	private void _r(com.fc.lami.Messages.EnterRoomRequest msg, NetDataInput in) throws IOException {
		msg.room_no = in.readInt();
	}
	private void _w(com.fc.lami.Messages.EnterRoomRequest msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.room_no);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.EnterRoomResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.EnterRoomResponse new_com_fc_lami_Messages_EnterRoomResponse(){return new com.fc.lami.Messages.EnterRoomResponse();}
	private void _r(com.fc.lami.Messages.EnterRoomResponse msg, NetDataInput in) throws IOException {
		msg.result = in.readInt();
		msg.room = in.readExternal(com.fc.lami.Messages.RoomData.class);
	}
	private void _w(com.fc.lami.Messages.EnterRoomResponse msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.result);
		out.writeExternal(msg.room);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.ExitRoomNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.ExitRoomNotify new_com_fc_lami_Messages_ExitRoomNotify(){return new com.fc.lami.Messages.ExitRoomNotify();}
	private void _r(com.fc.lami.Messages.ExitRoomNotify msg, NetDataInput in) throws IOException {
		msg.player_id = in.readInt();
	}
	private void _w(com.fc.lami.Messages.ExitRoomNotify msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.player_id);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.ExitRoomRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.ExitRoomRequest new_com_fc_lami_Messages_ExitRoomRequest(){return new com.fc.lami.Messages.ExitRoomRequest();}
	private void _r(com.fc.lami.Messages.ExitRoomRequest msg, NetDataInput in) throws IOException {
	}
	private void _w(com.fc.lami.Messages.ExitRoomRequest msg, NetDataOutput out) throws IOException {
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.ExitRoomResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.ExitRoomResponse new_com_fc_lami_Messages_ExitRoomResponse(){return new com.fc.lami.Messages.ExitRoomResponse();}
	private void _r(com.fc.lami.Messages.ExitRoomResponse msg, NetDataInput in) throws IOException {
		msg.rooms = (com.fc.lami.Messages.RoomSnapShot[])in.readExternalArray(com.fc.lami.Messages.RoomSnapShot.class);
	}
	private void _w(com.fc.lami.Messages.ExitRoomResponse msg, NetDataOutput out) throws IOException {
		out.writeExternalArray(msg.rooms);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.FreshRoomNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.FreshRoomNotify new_com_fc_lami_Messages_FreshRoomNotify(){return new com.fc.lami.Messages.FreshRoomNotify();}
	private void _r(com.fc.lami.Messages.FreshRoomNotify msg, NetDataInput in) throws IOException {
		msg.room = in.readExternal(com.fc.lami.Messages.RoomSnapShot.class);
	}
	private void _w(com.fc.lami.Messages.FreshRoomNotify msg, NetDataOutput out) throws IOException {
		out.writeExternal(msg.room);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.GameOverNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.GameOverNotify new_com_fc_lami_Messages_GameOverNotify(){return new com.fc.lami.Messages.GameOverNotify();}
	private void _r(com.fc.lami.Messages.GameOverNotify msg, NetDataInput in) throws IOException {
		msg.game_over_type = in.readInt();
		msg.result_pak = (com.fc.lami.Messages.ResultPak[])in.readExternalArray(com.fc.lami.Messages.ResultPak.class);
	}
	private void _w(com.fc.lami.Messages.GameOverNotify msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.game_over_type);
		out.writeExternalArray(msg.result_pak);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.GameOverToRoomNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.GameOverToRoomNotify new_com_fc_lami_Messages_GameOverToRoomNotify(){return new com.fc.lami.Messages.GameOverToRoomNotify();}
	private void _r(com.fc.lami.Messages.GameOverToRoomNotify msg, NetDataInput in) throws IOException {
		msg.desk_id = in.readInt();
	}
	private void _w(com.fc.lami.Messages.GameOverToRoomNotify msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.desk_id);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.GameResetNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.GameResetNotify new_com_fc_lami_Messages_GameResetNotify(){return new com.fc.lami.Messages.GameResetNotify();}
	private void _r(com.fc.lami.Messages.GameResetNotify msg, NetDataInput in) throws IOException {
		msg.player_id = in.readInt();
	}
	private void _w(com.fc.lami.Messages.GameResetNotify msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.player_id);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.GameResetRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.GameResetRequest new_com_fc_lami_Messages_GameResetRequest(){return new com.fc.lami.Messages.GameResetRequest();}
	private void _r(com.fc.lami.Messages.GameResetRequest msg, NetDataInput in) throws IOException {
		msg.is_reset = in.readBoolean();
	}
	private void _w(com.fc.lami.Messages.GameResetRequest msg, NetDataOutput out) throws IOException {
		out.writeBoolean(msg.is_reset);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.GameResetResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.GameResetResponse new_com_fc_lami_Messages_GameResetResponse(){return new com.fc.lami.Messages.GameResetResponse();}
	private void _r(com.fc.lami.Messages.GameResetResponse msg, NetDataInput in) throws IOException {
		msg.result = in.readInt();
	}
	private void _w(com.fc.lami.Messages.GameResetResponse msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.result);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.GameStartNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.GameStartNotify new_com_fc_lami_Messages_GameStartNotify(){return new com.fc.lami.Messages.GameStartNotify();}
	private void _r(com.fc.lami.Messages.GameStartNotify msg, NetDataInput in) throws IOException {
		msg.cards = (com.fc.lami.Messages.CardData[])in.readExternalArray(com.fc.lami.Messages.CardData.class);
	}
	private void _w(com.fc.lami.Messages.GameStartNotify msg, NetDataOutput out) throws IOException {
		out.writeExternalArray(msg.cards);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.GameStartToRoomNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.GameStartToRoomNotify new_com_fc_lami_Messages_GameStartToRoomNotify(){return new com.fc.lami.Messages.GameStartToRoomNotify();}
	private void _r(com.fc.lami.Messages.GameStartToRoomNotify msg, NetDataInput in) throws IOException {
		msg.desk_id = in.readInt();
	}
	private void _w(com.fc.lami.Messages.GameStartToRoomNotify msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.desk_id);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.GetCardNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.GetCardNotify new_com_fc_lami_Messages_GetCardNotify(){return new com.fc.lami.Messages.GetCardNotify();}
	private void _r(com.fc.lami.Messages.GetCardNotify msg, NetDataInput in) throws IOException {
		msg.cards = (com.fc.lami.Messages.CardData[])in.readExternalArray(com.fc.lami.Messages.CardData.class);
	}
	private void _w(com.fc.lami.Messages.GetCardNotify msg, NetDataOutput out) throws IOException {
		out.writeExternalArray(msg.cards);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.GetCardOverRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.GetCardOverRequest new_com_fc_lami_Messages_GetCardOverRequest(){return new com.fc.lami.Messages.GetCardOverRequest();}
	private void _r(com.fc.lami.Messages.GetCardOverRequest msg, NetDataInput in) throws IOException {
	}
	private void _w(com.fc.lami.Messages.GetCardOverRequest msg, NetDataOutput out) throws IOException {
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.GetCardOverResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.GetCardOverResponse new_com_fc_lami_Messages_GetCardOverResponse(){return new com.fc.lami.Messages.GetCardOverResponse();}
	private void _r(com.fc.lami.Messages.GetCardOverResponse msg, NetDataInput in) throws IOException {
		msg.is_can_reset = in.readBoolean();
	}
	private void _w(com.fc.lami.Messages.GetCardOverResponse msg, NetDataOutput out) throws IOException {
		out.writeBoolean(msg.is_can_reset);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.GetCardRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.GetCardRequest new_com_fc_lami_Messages_GetCardRequest(){return new com.fc.lami.Messages.GetCardRequest();}
	private void _r(com.fc.lami.Messages.GetCardRequest msg, NetDataInput in) throws IOException {
	}
	private void _w(com.fc.lami.Messages.GetCardRequest msg, NetDataOutput out) throws IOException {
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.GetCardResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.GetCardResponse new_com_fc_lami_Messages_GetCardResponse(){return new com.fc.lami.Messages.GetCardResponse();}
	private void _r(com.fc.lami.Messages.GetCardResponse msg, NetDataInput in) throws IOException {
		msg.result = in.readInt();
	}
	private void _w(com.fc.lami.Messages.GetCardResponse msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.result);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.GetPlayerDataRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.GetPlayerDataRequest new_com_fc_lami_Messages_GetPlayerDataRequest(){return new com.fc.lami.Messages.GetPlayerDataRequest();}
	private void _r(com.fc.lami.Messages.GetPlayerDataRequest msg, NetDataInput in) throws IOException {
		msg.player_id = in.readInt();
	}
	private void _w(com.fc.lami.Messages.GetPlayerDataRequest msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.player_id);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.GetPlayerDataResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.GetPlayerDataResponse new_com_fc_lami_Messages_GetPlayerDataResponse(){return new com.fc.lami.Messages.GetPlayerDataResponse();}
	private void _r(com.fc.lami.Messages.GetPlayerDataResponse msg, NetDataInput in) throws IOException {
		msg.player = in.readExternal(com.fc.lami.Messages.PlayerData.class);
	}
	private void _w(com.fc.lami.Messages.GetPlayerDataResponse msg, NetDataOutput out) throws IOException {
		out.writeExternal(msg.player);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.GetTimeRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.GetTimeRequest new_com_fc_lami_Messages_GetTimeRequest(){return new com.fc.lami.Messages.GetTimeRequest();}
	private void _r(com.fc.lami.Messages.GetTimeRequest msg, NetDataInput in) throws IOException {
		msg.message = in.readUTF();
	}
	private void _w(com.fc.lami.Messages.GetTimeRequest msg, NetDataOutput out) throws IOException {
		out.writeUTF(msg.message);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.GetTimeResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.GetTimeResponse new_com_fc_lami_Messages_GetTimeResponse(){return new com.fc.lami.Messages.GetTimeResponse();}
	private void _r(com.fc.lami.Messages.GetTimeResponse msg, NetDataInput in) throws IOException {
		msg.time = in.readUTF();
	}
	private void _w(com.fc.lami.Messages.GetTimeResponse msg, NetDataOutput out) throws IOException {
		out.writeUTF(msg.time);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.KickOutNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.KickOutNotify new_com_fc_lami_Messages_KickOutNotify(){return new com.fc.lami.Messages.KickOutNotify();}
	private void _r(com.fc.lami.Messages.KickOutNotify msg, NetDataInput in) throws IOException {
		msg.reason = in.readInt();
	}
	private void _w(com.fc.lami.Messages.KickOutNotify msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.reason);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.LeaveDeskForceRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.LeaveDeskForceRequest new_com_fc_lami_Messages_LeaveDeskForceRequest(){return new com.fc.lami.Messages.LeaveDeskForceRequest();}
	private void _r(com.fc.lami.Messages.LeaveDeskForceRequest msg, NetDataInput in) throws IOException {
	}
	private void _w(com.fc.lami.Messages.LeaveDeskForceRequest msg, NetDataOutput out) throws IOException {
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.LeaveDeskForceResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.LeaveDeskForceResponse new_com_fc_lami_Messages_LeaveDeskForceResponse(){return new com.fc.lami.Messages.LeaveDeskForceResponse();}
	private void _r(com.fc.lami.Messages.LeaveDeskForceResponse msg, NetDataInput in) throws IOException {
		msg.result = in.readInt();
	}
	private void _w(com.fc.lami.Messages.LeaveDeskForceResponse msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.result);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.LeaveDeskNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.LeaveDeskNotify new_com_fc_lami_Messages_LeaveDeskNotify(){return new com.fc.lami.Messages.LeaveDeskNotify();}
	private void _r(com.fc.lami.Messages.LeaveDeskNotify msg, NetDataInput in) throws IOException {
		msg.player_id = in.readInt();
		msg.desk_id = in.readInt();
	}
	private void _w(com.fc.lami.Messages.LeaveDeskNotify msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.player_id);
		out.writeInt(msg.desk_id);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.LeaveDeskRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.LeaveDeskRequest new_com_fc_lami_Messages_LeaveDeskRequest(){return new com.fc.lami.Messages.LeaveDeskRequest();}
	private void _r(com.fc.lami.Messages.LeaveDeskRequest msg, NetDataInput in) throws IOException {
	}
	private void _w(com.fc.lami.Messages.LeaveDeskRequest msg, NetDataOutput out) throws IOException {
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.LeaveDeskResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.LeaveDeskResponse new_com_fc_lami_Messages_LeaveDeskResponse(){return new com.fc.lami.Messages.LeaveDeskResponse();}
	private void _r(com.fc.lami.Messages.LeaveDeskResponse msg, NetDataInput in) throws IOException {
		msg.result = in.readInt();
	}
	private void _w(com.fc.lami.Messages.LeaveDeskResponse msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.result);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.LoginRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.LoginRequest new_com_fc_lami_Messages_LoginRequest(){return new com.fc.lami.Messages.LoginRequest();}
	private void _r(com.fc.lami.Messages.LoginRequest msg, NetDataInput in) throws IOException {
		msg.platform_user_data = in.readExternal(com.fc.lami.Messages.PlatformUserData.class);
		msg.validate = in.readUTF();
		msg.version = in.readUTF();
	}
	private void _w(com.fc.lami.Messages.LoginRequest msg, NetDataOutput out) throws IOException {
		out.writeExternal(msg.platform_user_data);
		out.writeUTF(msg.validate);
		out.writeUTF(msg.version);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.LoginResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.LoginResponse new_com_fc_lami_Messages_LoginResponse(){return new com.fc.lami.Messages.LoginResponse();}
	private void _r(com.fc.lami.Messages.LoginResponse msg, NetDataInput in) throws IOException {
		msg.result = in.readShort();
		msg.player = in.readExternal(com.fc.lami.Messages.PlayerData.class);
		msg.rooms = (com.fc.lami.Messages.RoomSnapShot[])in.readExternalArray(com.fc.lami.Messages.RoomSnapShot.class);
		msg.version = in.readUTF();
		msg.reason = in.readUTF();
	}
	private void _w(com.fc.lami.Messages.LoginResponse msg, NetDataOutput out) throws IOException {
		out.writeShort(msg.result);
		out.writeExternal(msg.player);
		out.writeExternalArray(msg.rooms);
		out.writeUTF(msg.version);
		out.writeUTF(msg.reason);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.LogoutRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.LogoutRequest new_com_fc_lami_Messages_LogoutRequest(){return new com.fc.lami.Messages.LogoutRequest();}
	private void _r(com.fc.lami.Messages.LogoutRequest msg, NetDataInput in) throws IOException {
	}
	private void _w(com.fc.lami.Messages.LogoutRequest msg, NetDataOutput out) throws IOException {
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.MainMatrixChangeNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.MainMatrixChangeNotify new_com_fc_lami_Messages_MainMatrixChangeNotify(){return new com.fc.lami.Messages.MainMatrixChangeNotify();}
	private void _r(com.fc.lami.Messages.MainMatrixChangeNotify msg, NetDataInput in) throws IOException {
		msg.is_hardhanded = in.readBoolean();
		msg.cards = (com.fc.lami.Messages.CardData[])in.readExternalArray(com.fc.lami.Messages.CardData.class);
		msg.player_id = in.readInt();
	}
	private void _w(com.fc.lami.Messages.MainMatrixChangeNotify msg, NetDataOutput out) throws IOException {
		out.writeBoolean(msg.is_hardhanded);
		out.writeExternalArray(msg.cards);
		out.writeInt(msg.player_id);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.MainMatrixChangeRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.MainMatrixChangeRequest new_com_fc_lami_Messages_MainMatrixChangeRequest(){return new com.fc.lami.Messages.MainMatrixChangeRequest();}
	private void _r(com.fc.lami.Messages.MainMatrixChangeRequest msg, NetDataInput in) throws IOException {
		msg.cards = (com.fc.lami.Messages.CardData[])in.readExternalArray(com.fc.lami.Messages.CardData.class);
	}
	private void _w(com.fc.lami.Messages.MainMatrixChangeRequest msg, NetDataOutput out) throws IOException {
		out.writeExternalArray(msg.cards);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.MainMatrixChangeResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.MainMatrixChangeResponse new_com_fc_lami_Messages_MainMatrixChangeResponse(){return new com.fc.lami.Messages.MainMatrixChangeResponse();}
	private void _r(com.fc.lami.Messages.MainMatrixChangeResponse msg, NetDataInput in) throws IOException {
		msg.result = in.readInt();
	}
	private void _w(com.fc.lami.Messages.MainMatrixChangeResponse msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.result);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.MoveCardToDeskRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.MoveCardToDeskRequest new_com_fc_lami_Messages_MoveCardToDeskRequest(){return new com.fc.lami.Messages.MoveCardToDeskRequest();}
	private void _r(com.fc.lami.Messages.MoveCardToDeskRequest msg, NetDataInput in) throws IOException {
		msg.ids = in.readIntArray();
		msg.x = in.readInt();
		msg.y = in.readInt();
	}
	private void _w(com.fc.lami.Messages.MoveCardToDeskRequest msg, NetDataOutput out) throws IOException {
		out.writeIntArray(msg.ids);
		out.writeInt(msg.x);
		out.writeInt(msg.y);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.MoveCardToDeskResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.MoveCardToDeskResponse new_com_fc_lami_Messages_MoveCardToDeskResponse(){return new com.fc.lami.Messages.MoveCardToDeskResponse();}
	private void _r(com.fc.lami.Messages.MoveCardToDeskResponse msg, NetDataInput in) throws IOException {
		msg.result = in.readInt();
		msg.ids = in.readIntArray();
		msg.x = in.readInt();
		msg.y = in.readInt();
	}
	private void _w(com.fc.lami.Messages.MoveCardToDeskResponse msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.result);
		out.writeIntArray(msg.ids);
		out.writeInt(msg.x);
		out.writeInt(msg.y);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.MoveCardToPlayerRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.MoveCardToPlayerRequest new_com_fc_lami_Messages_MoveCardToPlayerRequest(){return new com.fc.lami.Messages.MoveCardToPlayerRequest();}
	private void _r(com.fc.lami.Messages.MoveCardToPlayerRequest msg, NetDataInput in) throws IOException {
		msg.ids = in.readIntArray();
		msg.x = in.readInt();
		msg.y = in.readInt();
	}
	private void _w(com.fc.lami.Messages.MoveCardToPlayerRequest msg, NetDataOutput out) throws IOException {
		out.writeIntArray(msg.ids);
		out.writeInt(msg.x);
		out.writeInt(msg.y);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.MoveCardToPlayerResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.MoveCardToPlayerResponse new_com_fc_lami_Messages_MoveCardToPlayerResponse(){return new com.fc.lami.Messages.MoveCardToPlayerResponse();}
	private void _r(com.fc.lami.Messages.MoveCardToPlayerResponse msg, NetDataInput in) throws IOException {
		msg.result = in.readInt();
		msg.ids = in.readIntArray();
	}
	private void _w(com.fc.lami.Messages.MoveCardToPlayerResponse msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.result);
		out.writeIntArray(msg.ids);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.OpenIceNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.OpenIceNotify new_com_fc_lami_Messages_OpenIceNotify(){return new com.fc.lami.Messages.OpenIceNotify();}
	private void _r(com.fc.lami.Messages.OpenIceNotify msg, NetDataInput in) throws IOException {
		msg.player_id = in.readInt();
	}
	private void _w(com.fc.lami.Messages.OpenIceNotify msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.player_id);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.OperateCompleteNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.OperateCompleteNotify new_com_fc_lami_Messages_OperateCompleteNotify(){return new com.fc.lami.Messages.OperateCompleteNotify();}
	private void _r(com.fc.lami.Messages.OperateCompleteNotify msg, NetDataInput in) throws IOException {
		msg.player_id = in.readInt();
	}
	private void _w(com.fc.lami.Messages.OperateCompleteNotify msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.player_id);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.PlatformUserData
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.PlatformUserData new_com_fc_lami_Messages_PlatformUserData(){return new com.fc.lami.Messages.PlatformUserData();}
	private void _r(com.fc.lami.Messages.PlatformUserData msg, NetDataInput in) throws IOException {
		msg.platform_uid = in.readUTF();
		msg.user_uid = in.readUTF();
		msg.user_name = in.readUTF();
		msg.user_sex = in.readUTF();
		msg.user_image_url = in.readUTF();
	}
	private void _w(com.fc.lami.Messages.PlatformUserData msg, NetDataOutput out) throws IOException {
		out.writeUTF(msg.platform_uid);
		out.writeUTF(msg.user_uid);
		out.writeUTF(msg.user_name);
		out.writeUTF(msg.user_sex);
		out.writeUTF(msg.user_image_url);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.PlayerData
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.PlayerData new_com_fc_lami_Messages_PlayerData(){return new com.fc.lami.Messages.PlayerData();}
	private void _r(com.fc.lami.Messages.PlayerData msg, NetDataInput in) throws IOException {
		msg.player_id = in.readInt();
		msg.uid = in.readUTF();
		msg.player_name = in.readUTF();
		msg.player_head_url = in.readUTF();
		msg.sex = in.readUTF();
		msg.is_first_game = in.readBoolean();
		msg.score = in.readInt();
		msg.win = in.readInt();
		msg.lose = in.readInt();
		msg.level = in.readInt();
	}
	private void _w(com.fc.lami.Messages.PlayerData msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.player_id);
		out.writeUTF(msg.uid);
		out.writeUTF(msg.player_name);
		out.writeUTF(msg.player_head_url);
		out.writeUTF(msg.sex);
		out.writeBoolean(msg.is_first_game);
		out.writeInt(msg.score);
		out.writeInt(msg.win);
		out.writeInt(msg.lose);
		out.writeInt(msg.level);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.PlayerState
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.PlayerState new_com_fc_lami_Messages_PlayerState(){return new com.fc.lami.Messages.PlayerState();}
	private void _r(com.fc.lami.Messages.PlayerState msg, NetDataInput in) throws IOException {
		msg.player_id = in.readInt();
		msg.is_ready = in.readBoolean();
		msg.is_openice = in.readBoolean();
	}
	private void _w(com.fc.lami.Messages.PlayerState msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.player_id);
		out.writeBoolean(msg.is_ready);
		out.writeBoolean(msg.is_openice);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.PlayerUpdateNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.PlayerUpdateNotify new_com_fc_lami_Messages_PlayerUpdateNotify(){return new com.fc.lami.Messages.PlayerUpdateNotify();}
	private void _r(com.fc.lami.Messages.PlayerUpdateNotify msg, NetDataInput in) throws IOException {
		msg.player = in.readExternal(com.fc.lami.Messages.PlayerData.class);
	}
	private void _w(com.fc.lami.Messages.PlayerUpdateNotify msg, NetDataOutput out) throws IOException {
		out.writeExternal(msg.player);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.ReadyNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.ReadyNotify new_com_fc_lami_Messages_ReadyNotify(){return new com.fc.lami.Messages.ReadyNotify();}
	private void _r(com.fc.lami.Messages.ReadyNotify msg, NetDataInput in) throws IOException {
		msg.player_id = in.readInt();
		msg.isReady = in.readBoolean();
	}
	private void _w(com.fc.lami.Messages.ReadyNotify msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.player_id);
		out.writeBoolean(msg.isReady);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.ReadyRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.ReadyRequest new_com_fc_lami_Messages_ReadyRequest(){return new com.fc.lami.Messages.ReadyRequest();}
	private void _r(com.fc.lami.Messages.ReadyRequest msg, NetDataInput in) throws IOException {
		msg.isReady = in.readBoolean();
	}
	private void _w(com.fc.lami.Messages.ReadyRequest msg, NetDataOutput out) throws IOException {
		out.writeBoolean(msg.isReady);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.ReadyResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.ReadyResponse new_com_fc_lami_Messages_ReadyResponse(){return new com.fc.lami.Messages.ReadyResponse();}
	private void _r(com.fc.lami.Messages.ReadyResponse msg, NetDataInput in) throws IOException {
	}
	private void _w(com.fc.lami.Messages.ReadyResponse msg, NetDataOutput out) throws IOException {
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.RepealSendCardNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.RepealSendCardNotify new_com_fc_lami_Messages_RepealSendCardNotify(){return new com.fc.lami.Messages.RepealSendCardNotify();}
	private void _r(com.fc.lami.Messages.RepealSendCardNotify msg, NetDataInput in) throws IOException {
		msg.player_id = in.readInt();
		msg.cds = (com.fc.lami.Messages.CardData[])in.readExternalArray(com.fc.lami.Messages.CardData.class);
	}
	private void _w(com.fc.lami.Messages.RepealSendCardNotify msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.player_id);
		out.writeExternalArray(msg.cds);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.RepealSendCardRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.RepealSendCardRequest new_com_fc_lami_Messages_RepealSendCardRequest(){return new com.fc.lami.Messages.RepealSendCardRequest();}
	private void _r(com.fc.lami.Messages.RepealSendCardRequest msg, NetDataInput in) throws IOException {
	}
	private void _w(com.fc.lami.Messages.RepealSendCardRequest msg, NetDataOutput out) throws IOException {
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.RepealSendCardResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.RepealSendCardResponse new_com_fc_lami_Messages_RepealSendCardResponse(){return new com.fc.lami.Messages.RepealSendCardResponse();}
	private void _r(com.fc.lami.Messages.RepealSendCardResponse msg, NetDataInput in) throws IOException {
	}
	private void _w(com.fc.lami.Messages.RepealSendCardResponse msg, NetDataOutput out) throws IOException {
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.ResultPak
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.ResultPak new_com_fc_lami_Messages_ResultPak(){return new com.fc.lami.Messages.ResultPak();}
	private void _r(com.fc.lami.Messages.ResultPak msg, NetDataInput in) throws IOException {
		msg.point = in.readInt();
		msg.player_id = in.readInt();
		msg.is_win = in.readBoolean();
	}
	private void _w(com.fc.lami.Messages.ResultPak msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.point);
		out.writeInt(msg.player_id);
		out.writeBoolean(msg.is_win);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.RoomData
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.RoomData new_com_fc_lami_Messages_RoomData(){return new com.fc.lami.Messages.RoomData();}
	private void _r(com.fc.lami.Messages.RoomData msg, NetDataInput in) throws IOException {
		msg.room_id = in.readInt();
		msg.room_name = in.readUTF();
		msg.desks = (com.fc.lami.Messages.DeskData[])in.readExternalArray(com.fc.lami.Messages.DeskData.class);
		msg.players = (com.fc.lami.Messages.PlayerData[])in.readExternalArray(com.fc.lami.Messages.PlayerData.class);
	}
	private void _w(com.fc.lami.Messages.RoomData msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.room_id);
		out.writeUTF(msg.room_name);
		out.writeExternalArray(msg.desks);
		out.writeExternalArray(msg.players);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.RoomSnapShot
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.RoomSnapShot new_com_fc_lami_Messages_RoomSnapShot(){return new com.fc.lami.Messages.RoomSnapShot();}
	private void _r(com.fc.lami.Messages.RoomSnapShot msg, NetDataInput in) throws IOException {
		msg.room_id = in.readInt();
		msg.room_name = in.readUTF();
		msg.player_number_max = in.readInt();
		msg.player_number = in.readInt();
	}
	private void _w(com.fc.lami.Messages.RoomSnapShot msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.room_id);
		out.writeUTF(msg.room_name);
		out.writeInt(msg.player_number_max);
		out.writeInt(msg.player_number);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.SpeakToChannelNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.SpeakToChannelNotify new_com_fc_lami_Messages_SpeakToChannelNotify(){return new com.fc.lami.Messages.SpeakToChannelNotify();}
	private void _r(com.fc.lami.Messages.SpeakToChannelNotify msg, NetDataInput in) throws IOException {
		msg.player_id = in.readInt();
		msg.message = in.readUTF();
	}
	private void _w(com.fc.lami.Messages.SpeakToChannelNotify msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.player_id);
		out.writeUTF(msg.message);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.SpeakToChannelRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.SpeakToChannelRequest new_com_fc_lami_Messages_SpeakToChannelRequest(){return new com.fc.lami.Messages.SpeakToChannelRequest();}
	private void _r(com.fc.lami.Messages.SpeakToChannelRequest msg, NetDataInput in) throws IOException {
		msg.channel = in.readInt();
		msg.message = in.readUTF();
	}
	private void _w(com.fc.lami.Messages.SpeakToChannelRequest msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.channel);
		out.writeUTF(msg.message);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.SpeakToChannelResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.SpeakToChannelResponse new_com_fc_lami_Messages_SpeakToChannelResponse(){return new com.fc.lami.Messages.SpeakToChannelResponse();}
	private void _r(com.fc.lami.Messages.SpeakToChannelResponse msg, NetDataInput in) throws IOException {
		msg.result = in.readInt();
	}
	private void _w(com.fc.lami.Messages.SpeakToChannelResponse msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.result);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.SpeakToPrivateNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.SpeakToPrivateNotify new_com_fc_lami_Messages_SpeakToPrivateNotify(){return new com.fc.lami.Messages.SpeakToPrivateNotify();}
	private void _r(com.fc.lami.Messages.SpeakToPrivateNotify msg, NetDataInput in) throws IOException {
		msg.player_name = in.readUTF();
		msg.message = in.readUTF();
	}
	private void _w(com.fc.lami.Messages.SpeakToPrivateNotify msg, NetDataOutput out) throws IOException {
		out.writeUTF(msg.player_name);
		out.writeUTF(msg.message);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.SpeakToPrivateRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.SpeakToPrivateRequest new_com_fc_lami_Messages_SpeakToPrivateRequest(){return new com.fc.lami.Messages.SpeakToPrivateRequest();}
	private void _r(com.fc.lami.Messages.SpeakToPrivateRequest msg, NetDataInput in) throws IOException {
		msg.player_name = in.readUTF();
		msg.message = in.readUTF();
	}
	private void _w(com.fc.lami.Messages.SpeakToPrivateRequest msg, NetDataOutput out) throws IOException {
		out.writeUTF(msg.player_name);
		out.writeUTF(msg.message);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.SpeakToPrivateResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.SpeakToPrivateResponse new_com_fc_lami_Messages_SpeakToPrivateResponse(){return new com.fc.lami.Messages.SpeakToPrivateResponse();}
	private void _r(com.fc.lami.Messages.SpeakToPrivateResponse msg, NetDataInput in) throws IOException {
		msg.result = in.readInt();
	}
	private void _w(com.fc.lami.Messages.SpeakToPrivateResponse msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.result);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.SpeakToPublicNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.SpeakToPublicNotify new_com_fc_lami_Messages_SpeakToPublicNotify(){return new com.fc.lami.Messages.SpeakToPublicNotify();}
	private void _r(com.fc.lami.Messages.SpeakToPublicNotify msg, NetDataInput in) throws IOException {
		msg.player_id = in.readInt();
		msg.channel_type = in.readInt();
		msg.message = in.readUTF();
	}
	private void _w(com.fc.lami.Messages.SpeakToPublicNotify msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.player_id);
		out.writeInt(msg.channel_type);
		out.writeUTF(msg.message);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.SpeakToPublicRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.SpeakToPublicRequest new_com_fc_lami_Messages_SpeakToPublicRequest(){return new com.fc.lami.Messages.SpeakToPublicRequest();}
	private void _r(com.fc.lami.Messages.SpeakToPublicRequest msg, NetDataInput in) throws IOException {
		msg.message = in.readUTF();
	}
	private void _w(com.fc.lami.Messages.SpeakToPublicRequest msg, NetDataOutput out) throws IOException {
		out.writeUTF(msg.message);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.SpeakToPublicResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.SpeakToPublicResponse new_com_fc_lami_Messages_SpeakToPublicResponse(){return new com.fc.lami.Messages.SpeakToPublicResponse();}
	private void _r(com.fc.lami.Messages.SpeakToPublicResponse msg, NetDataInput in) throws IOException {
	}
	private void _w(com.fc.lami.Messages.SpeakToPublicResponse msg, NetDataOutput out) throws IOException {
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.SubmitRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.SubmitRequest new_com_fc_lami_Messages_SubmitRequest(){return new com.fc.lami.Messages.SubmitRequest();}
	private void _r(com.fc.lami.Messages.SubmitRequest msg, NetDataInput in) throws IOException {
	}
	private void _w(com.fc.lami.Messages.SubmitRequest msg, NetDataOutput out) throws IOException {
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.SubmitResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.SubmitResponse new_com_fc_lami_Messages_SubmitResponse(){return new com.fc.lami.Messages.SubmitResponse();}
	private void _r(com.fc.lami.Messages.SubmitResponse msg, NetDataInput in) throws IOException {
		msg.result = in.readInt();
		msg.fail_cards = in.readIntArray();
	}
	private void _w(com.fc.lami.Messages.SubmitResponse msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.result);
		out.writeIntArray(msg.fail_cards);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.SynchronizeRequest
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.SynchronizeRequest new_com_fc_lami_Messages_SynchronizeRequest(){return new com.fc.lami.Messages.SynchronizeRequest();}
	private void _r(com.fc.lami.Messages.SynchronizeRequest msg, NetDataInput in) throws IOException {
	}
	private void _w(com.fc.lami.Messages.SynchronizeRequest msg, NetDataOutput out) throws IOException {
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.SynchronizeResponse
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.SynchronizeResponse new_com_fc_lami_Messages_SynchronizeResponse(){return new com.fc.lami.Messages.SynchronizeResponse();}
	private void _r(com.fc.lami.Messages.SynchronizeResponse msg, NetDataInput in) throws IOException {
		msg.matrix = (com.fc.lami.Messages.CardData[])in.readExternalArray(com.fc.lami.Messages.CardData.class);
		msg.player_card = (com.fc.lami.Messages.CardData[])in.readExternalArray(com.fc.lami.Messages.CardData.class);
		msg.left_card = in.readInt();
	}
	private void _w(com.fc.lami.Messages.SynchronizeResponse msg, NetDataOutput out) throws IOException {
		out.writeExternalArray(msg.matrix);
		out.writeExternalArray(msg.player_card);
		out.writeInt(msg.left_card);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.TimeOutNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.TimeOutNotify new_com_fc_lami_Messages_TimeOutNotify(){return new com.fc.lami.Messages.TimeOutNotify();}
	private void _r(com.fc.lami.Messages.TimeOutNotify msg, NetDataInput in) throws IOException {
		msg.player_id = in.readInt();
	}
	private void _w(com.fc.lami.Messages.TimeOutNotify msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.player_id);
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.TurnEndNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.TurnEndNotify new_com_fc_lami_Messages_TurnEndNotify(){return new com.fc.lami.Messages.TurnEndNotify();}
	private void _r(com.fc.lami.Messages.TurnEndNotify msg, NetDataInput in) throws IOException {
	}
	private void _w(com.fc.lami.Messages.TurnEndNotify msg, NetDataOutput out) throws IOException {
	}

//	----------------------------------------------------------------------------------------------------
//	com.fc.lami.Messages.TurnStartNotify
//	----------------------------------------------------------------------------------------------------
	public com.fc.lami.Messages.TurnStartNotify new_com_fc_lami_Messages_TurnStartNotify(){return new com.fc.lami.Messages.TurnStartNotify();}
	private void _r(com.fc.lami.Messages.TurnStartNotify msg, NetDataInput in) throws IOException {
		msg.player_id = in.readInt();
		msg.stack_num = in.readInt();
	}
	private void _w(com.fc.lami.Messages.TurnStartNotify msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.player_id);
		out.writeInt(msg.stack_num);
	}


}
