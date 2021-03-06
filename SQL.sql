USE [student]
GO
/****** Object:  Table [dbo].[UserTeacher]    Script Date: 09/19/2017 14:28:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[UserTeacher](
	[usernum] [char](20) NULL,
	[password] [char](20) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[UserStudent]    Script Date: 09/19/2017 14:28:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[UserStudent](
	[usernum] [char](20) NULL,
	[password] [char](20) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[StuGrade3]    Script Date: 09/19/2017 14:28:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[StuGrade3](
	[stId] [char](20) NOT NULL,
	[stName] [char](20) NOT NULL,
	[stClass] [char](20) NOT NULL,
	[stCname3] [char](20) NULL,
	[stGrade3] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[stId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[StuGrade2]    Script Date: 09/19/2017 14:28:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[StuGrade2](
	[stId] [char](20) NOT NULL,
	[stName] [char](20) NOT NULL,
	[stClass] [char](20) NOT NULL,
	[stCname2] [char](20) NULL,
	[stGrade2] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[stId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[StuGrade]    Script Date: 09/19/2017 14:28:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[StuGrade](
	[stId] [char](20) NOT NULL,
	[stName] [char](20) NOT NULL,
	[stClass] [char](20) NOT NULL,
	[stCname1] [char](20) NULL,
	[stGrade1] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[stId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[st]    Script Date: 09/19/2017 14:28:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[st](
	[stId] [varchar](30) NOT NULL,
	[stNname] [nvarchar](50) NOT NULL,
	[stClass] [nvarchar](30) NOT NULL,
	[stCname1] [char](20) NULL,
	[stgrade1] [int] NULL,
	[stCname2] [char](20) NULL,
	[stgrade2] [int] NULL,
	[stCname3] [char](20) NULL,
	[stgrade3] [int] NULL,
	[avegrade] [int] NULL,
	[sumgrade] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[stId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
